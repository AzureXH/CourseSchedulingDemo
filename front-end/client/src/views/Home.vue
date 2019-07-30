<template>
  <div class="home" style="height:100%;"> 

    <el-container>
      
      <el-header>
        <el-menu default-active="1" class="nav" mode="horizontal"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router>

          <el-menu-item index="1" :route="$route.path">
            主页
          </el-menu-item>

          <a href="https://github.com/AzureXH/CourseSchedulingDemo">
            <el-menu-item index="2" :route="{path:'/about'}">
              关于
            </el-menu-item>
          </a>

        
        </el-menu>
      </el-header>
      
      <el-container id="main-container">
        <el-aside width="200px">
            <el-menu
            :default-active="$route.path"
            @open="handleOpen"
            @close="handleClose"
            router="true"
            unique-opened="true"
            background-color="#D3DCE6">

            <el-menu-item index="/home/course">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>课程大纲</span>
              </template>
            </el-menu-item>

            <el-menu-item index="/home/teacher">
              <i class="el-icon-menu"></i>
              <span slot="title">教师安排</span>
            </el-menu-item>

            <el-menu-item index="/home/classroom">
              <i class="el-icon-document"></i>
              <span slot="title">教室管理</span>
            </el-menu-item>

            <el-menu-item index="/home/scheduling">
              <i class="el-icon-setting"></i>
              <span slot="title">排课管理</span>
            </el-menu-item>

          </el-menu>
        </el-aside>
        <el-main>
            <keep-alive>
              <router-view></router-view>
            </keep-alive>
        </el-main>
      </el-container>

    </el-container>


  </div>
</template>

<script>
  export default {
    name: 'home'
  }
</script>
<style scoped>
.el-header{
  padding: 0;
}


.el-aside{
  height: 100%;
  background-color:#D3DCE6;
}

.el-main {
  color: #333;
  text-align: center;
  line-height: 160px;
}
.nav{
  width: 100%;
  display: flex;
  justify-content: space-evenly;
  text-decoration: none;
  
}
.el-container{
  height: 100%;
}
.el-menu{
  height: 100%;
  background-color: #D3DCE6;
}
</style>