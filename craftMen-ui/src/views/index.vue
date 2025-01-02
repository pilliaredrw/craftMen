<template>
  <div class="app-container home">
    <el-row>
      <el-col style="padding-left: 20px">
        <h2>欢迎来到craftMen制造装备物联及生产管理平台！</h2>
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
  color: #ebdd1b;
  overflow-x: hidden;
  background-image: url("../assets/images/main.jpg");
  background-size: cover;
  width: 1280px;
  height: 387px;
  border-radius: 20px; /* 圆角半径，可根据需求调整 */
  overflow: hidden; /* 确保内容不会溢出圆角边界 */
  margin-left: 30px;
  margin-top: 15px;
}
</style>

