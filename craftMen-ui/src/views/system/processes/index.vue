<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工艺编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入工艺编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工艺名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入工艺名称"
          clearable
          @keyup.enter="handleQuery"
        />
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
          v-hasPermi="['system:processes:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:processes:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:processes:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:processes:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="processesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工艺编号" align="center" prop="id" />
      <el-table-column label="工艺名称" align="center" prop="name" />
      <el-table-column label="外协价格" align="center" prop="outsourcingPrice" />
      <el-table-column label="瓶颈工序工期" align="center" prop="bottleneckDuration" />
      <el-table-column label="标准架构能力" align="center" prop="standardCapacity" />
      <el-table-column label="加班标准架构能力" align="center" prop="overtimeStandardCapacity" />
      <el-table-column label="加班超额加工能力" align="center" prop="overtimeExcessCapacity" />
      <el-table-column label="二班工序能力" align="center" prop="secondShiftCapacity" />
      <el-table-column label="超负荷工序能力" align="center" prop="overloadCapacity" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:processes:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:processes:remove']">删除</el-button>
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

    <!-- 添加或修改工艺管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="processesRef" :model="form" :rules="rules" label-width="160px">
        <el-form-item label="工艺名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入工艺名称" />
        </el-form-item>
        <el-form-item label="外协价格" prop="outsourcingPrice">
          <el-input v-model="form.outsourcingPrice" placeholder="请输入外协价格" />
        </el-form-item>
        <el-form-item label="瓶颈工序工期" prop="bottleneckDuration">
          <el-input v-model="form.bottleneckDuration" placeholder="请输入瓶颈工序工期" />
        </el-form-item>
        <el-form-item label="标准架构能力" prop="standardCapacity">
          <el-input v-model="form.standardCapacity" placeholder="请输入标准架构能力" />
        </el-form-item>
        <el-form-item label="加班标准架构能力" prop="overtimeStandardCapacity">
          <el-input v-model="form.overtimeStandardCapacity" placeholder="请输入加班标准架构能力" />
        </el-form-item>
        <el-form-item label="加班超额加工能力" prop="overtimeExcessCapacity">
          <el-input v-model="form.overtimeExcessCapacity" placeholder="请输入加班超额加工能力" />
        </el-form-item>
        <el-form-item label="二班工序能力" prop="secondShiftCapacity">
          <el-input v-model="form.secondShiftCapacity" placeholder="请输入二班工序能力" />
        </el-form-item>
        <el-form-item label="超负荷工序能力" prop="overloadCapacity">
          <el-input v-model="form.overloadCapacity" placeholder="请输入超负荷工序能力" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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

<script setup name="Processes">
import { listProcesses, getProcesses, delProcesses, addProcesses, updateProcesses } from "@/api/system/processes";

const { proxy } = getCurrentInstance();

const processesList = ref([]);
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
    name: null,
  },
  rules: {
    name: [
      { required: true, message: "工艺名称不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询工艺管理列表 */
function getList() {
  loading.value = true;
  listProcesses(queryParams.value).then(response => {
    processesList.value = response.rows;
    total.value = response.total;
    loading.value = false;
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
    name: null,
    outsourcingPrice: null,
    bottleneckDuration: null,
    standardCapacity: null,
    overtimeStandardCapacity: null,
    overtimeExcessCapacity: null,
    secondShiftCapacity: null,
    overloadCapacity: null,
    remark: null
  };
  proxy.resetForm("processesRef");
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
  title.value = "添加工艺管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getProcesses(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改工艺管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["processesRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateProcesses(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addProcesses(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除工艺管理编号为"' + _ids + '"的数据项？').then(function() {
    return delProcesses(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/processes/export', {
    ...queryParams.value
  }, `processes_${new Date().getTime()}.xlsx`)
}

getList();
</script>
