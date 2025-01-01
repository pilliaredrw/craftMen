<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="工艺计划编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入工艺计划编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工艺名称" prop="processId" style="width: 250px">
      <el-select
        v-model="queryParams.processId"
        placeholder="请选择工艺名称"
        clearable
        @change="handleQuery"
      >
        <el-option
          v-for="process in processList"
          :key="process.id"
          :label="process.name"
          :value="process.id"
        />
      </el-select>
    </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['system:plans:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:plans:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:plans:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:plans:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="plansList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工艺计划编号" align="center" prop="id" width="120" />
      <el-table-column label="工艺名称" align="center" prop="name" />
      <el-table-column label="批次数量" align="center" prop="batchQuantity" />
      <el-table-column label="计划开始时间" align="center" prop="planStart" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.planStart, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计划结束时间" align="center" prop="planEnd" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.planEnd, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计划提交时间" align="center" prop="submittedAt" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.submittedAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:plans:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:plans:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改工艺计划对话框 -->
    <el-dialog :title="title" v-model="open" width="400px" append-to-body>
      <el-form ref="plansRef" :model="form" :rules="rules" label-width="120px">
        <!-- 工艺名称下拉框 -->
        <el-form-item label="工艺名称" prop="processId">
          <el-select
            v-model="form.processId"
            placeholder="请选择工艺名称"
            filterable
          >
            <el-option
              v-for="process in processList"
              :key="process.id"
              :label="process.name"
              :value="process.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="批次数量" prop="batchQuantity">
          <el-input v-model="form.batchQuantity" placeholder="请输入批次数量" />
        </el-form-item>
        <el-form-item label="计划开始时间" prop="planStart">
          <el-date-picker clearable
            style="width: 100%;"
            v-model="form.planStart"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择计划开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="计划结束时间" prop="planEnd">
          <el-date-picker clearable
            style="width: 100%;"
            v-model="form.planEnd"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择计划结束时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Plans">
import { listPlans, getPlans, delPlans, addPlans, updatePlans } from "@/api/system/plans";
import { listProcesses } from "@/api/system/processes"; // 新增接口引入

const { proxy } = getCurrentInstance();

const plansList = ref([]);
const processList = ref([]); // 工艺列表数据
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    id: null,
    processId: null,
  },
  rules: {
    processId: [
      { required: true, message: "工艺编号不能为空", trigger: "blur" }
    ],
    batchQuantity: [
      { required: true, message: "批次数量不能为空", trigger: "blur" }
    ],
    planStart: [
      { required: true, message: "计划开始时间不能为空", trigger: "blur" }
    ],
    planEnd: [
      { required: true, message: "计划结束时间不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询工艺计划列表 */
function getList() {
  loading.value = true;
  listPlans(queryParams.value).then(response => {
    plansList.value = response.rows.map(item => {
      const matchedProcess = processList.value.find(process => process.id === item.processId);
      if (!matchedProcess) {
        console.warn(`No match for processId: ${item.processId}`); // 添加日志
      }
      return {
        ...item,
        name: matchedProcess?.name || '未知工艺' // 添加默认值
      };
    });
    total.value = response.total;
    loading.value = false;
  }).catch(error => {
    console.error("Failed to load requirements list:", error);
  });
}

/** 加载工艺列表 */
function loadProcessList() {
  listProcesses({ pageSize: 999, pageNum: 1 }).then(response => {
    processList.value = response.rows || [];
    getList();         // 保证要求列表的获取时工艺列表已加载
  }).catch(error => {
    console.error("Failed to load process list:", error);
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    processId: null,
    batchQuantity: null,
    planStart: null,
    planEnd: null,
    submittedAt: null
  };
  proxy.resetForm("plansRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加工艺计划";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getPlans(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改工艺计划";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["plansRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updatePlans(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addPlans(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除工艺计划编号为"' + _ids + '"的数据项？').then(function() {
    return delPlans(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/plans/export', {
    ...queryParams.value
  }, `plans_${new Date().getTime()}.xlsx`)
}

// 初始化加载
onMounted(() => {
  loadProcessList(); // 在组件挂载后立即加载工艺列表
});
</script>
