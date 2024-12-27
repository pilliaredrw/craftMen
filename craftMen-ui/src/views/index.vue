<template>
  <div class="app-container home">
    <el-row>
      <el-col style="padding-left: 20px">
        <h2>欢迎来到craftMen赋能的制造装备物联及生产管理平台！</h2>
      </el-col>
    </el-row>
  </div>
</template>

<script setup name="Index">

function goTarget(url) {
  window.open(url, '__blank')
}
</script>

<style scoped lang="scss">
.home {
  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;
}
</style>

