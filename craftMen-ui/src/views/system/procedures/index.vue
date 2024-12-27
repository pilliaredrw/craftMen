<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="工序编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入工序编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工艺计划编号" prop="planId">
        <el-input
          v-model="queryParams.planId"
          placeholder="请输入工艺计划编号"
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
          v-hasPermi="['system:procedures:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:procedures:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:procedures:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:procedures:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="proceduresList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工序编号" align="center" prop="id" />
      <el-table-column label="工艺计划编号" align="center" prop="planId" />
      <el-table-column label="工序顺序" align="center" prop="sequence" />
      <el-table-column label="单件定额工时" align="center" prop="quotaTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:procedures:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:procedures:remove']">删除</el-button>
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

    <!-- 添加或修改工序管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="proceduresRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工艺计划编号" prop="planId">
          <el-input v-model="form.planId" placeholder="请输入工艺计划编号" />
        </el-form-item>
        <el-form-item label="工序顺序" prop="sequence">
          <el-input v-model="form.sequence" placeholder="请输入工序顺序" />
        </el-form-item>
        <el-form-item label="单件定额工时" prop="quotaTime">
          <el-input v-model="form.quotaTime" placeholder="请输入单件定额工时" />
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

<script setup name="Procedures">
import { listProcedures, getProcedures, delProcedures, addProcedures, updateProcedures } from "@/api/system/procedures";

const { proxy } = getCurrentInstance();

const proceduresList = ref([]);
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
    planId: null,
  },
  rules: {
    planId: [
      { required: true, message: "工艺计划编号不能为空", trigger: "blur" }
    ],
    sequence: [
      { required: true, message: "工序顺序不能为空", trigger: "blur" }
    ],
    quotaTime: [
      { required: true, message: "单件定额工时不能为空", trigger: "blur" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询工序管理列表 */
function getList() {
  loading.value = true;
  listProcedures(queryParams.value).then(response => {
    proceduresList.value = response.rows;
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
    planId: null,
    sequence: null,
    quotaTime: null
  };
  proxy.resetForm("proceduresRef");
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
  title.value = "添加工序管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getProcedures(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改工序管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["proceduresRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateProcedures(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addProcedures(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除工序管理编号为"' + _ids + '"的数据项？').then(function() {
    return delProcedures(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/procedures/export', {
    ...queryParams.value
  }, `procedures_${new Date().getTime()}.xlsx`)
}

getList();
</script>
