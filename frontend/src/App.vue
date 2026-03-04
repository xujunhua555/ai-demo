<template>
  <div class="app">
    <el-container v-if="isLoggedIn">
      <el-aside width="220px" class="sidebar">
        <div class="logo">
          <el-icon :size="32"><Timer /></el-icon>
          <span>工时填报系统</span>
        </div>
        <el-menu 
          :router="true" 
          :default-active="$route.path" 
          class="menu"
          background-color="#304156"
          text-color="#bfcbd9"
          active-text-color="#409EFF"
        >
          <el-menu-item index="/">
            <el-icon><HomeFilled /></el-icon>
            <span>首页</span>
          </el-menu-item>
          <el-menu-item index="/users">
            <el-icon><UserFilled /></el-icon>
            <span>用户管理</span>
          </el-menu-item>
          <el-menu-item index="/roles">
            <el-icon><User /></el-icon>
            <span>角色管理</span>
          </el-menu-item>
          <el-menu-item index="/projects">
            <el-icon><Document /></el-icon>
            <span>项目管理</span>
          </el-menu-item>
          <el-menu-item index="/requirements">
            <el-icon><Message /></el-icon>
            <span>需求管理</span>
          </el-menu-item>
          <el-menu-item index="/timesheets">
            <el-icon><Timer /></el-icon>
            <span>工时填报</span>
          </el-menu-item>
          <el-menu-item index="/dashboard">
            <el-icon><PieChart /></el-icon>
            <span>看板</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header class="header" height="60px">
          <div class="header-left">
            <el-icon class="breadcrumb-icon" @click="goBack"><ArrowLeft /></el-icon>
          </div>
          <div class="header-right">
            <div class="user-info">
              <el-avatar :size="32" :icon="UserFilled" />
              <span class="username">{{ currentUser?.username || '用户' }}</span>
            </div>
            <el-divider direction="vertical" />
            <el-link type="danger" @click="logout" :underline="false">
              <el-icon><SwitchButton /></el-icon>
              退出登录
            </el-link>
          </div>
        </el-header>
        <el-main class="main-content">
          <router-view />
        </el-main>
      </el-container>
    </el-container>
    <router-view v-else />
  </div>
</template>

<script setup>
import { ref, computed, onMounted, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { 
  HomeFilled, 
  UserFilled, 
  User, 
  Document, 
  Message, 
  Timer, 
  PieChart,
  ArrowLeft,
  SwitchButton
} from '@element-plus/icons-vue'

const router = useRouter()
const route = useRoute()

const currentUser = ref(null)
const isLoggedIn = ref(false)

const checkLoginStatus = () => {
  const userInfo = localStorage.getItem('userInfo')
  const token = localStorage.getItem('token')
  if (userInfo && token) {
    currentUser.value = JSON.parse(userInfo)
    isLoggedIn.value = true
  } else {
    currentUser.value = null
    isLoggedIn.value = false
  }
}

onMounted(() => {
  checkLoginStatus()
})

watch(() => route.path, () => {
  checkLoginStatus()
})

const goBack = () => {
  router.back()
}

const logout = () => {
  localStorage.removeItem('token')
  localStorage.removeItem('userInfo')
  isLoggedIn.value = false
  currentUser.value = null
  router.push('/login')
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.app {
  height: 100vh;
  width: 100vw;
  overflow: hidden;
}

.sidebar {
  background-color: #304156;
  box-shadow: 2px 0 8px rgba(0, 0, 0, 0.1);
}

.logo {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  color: white;
  font-size: 18px;
  font-weight: 600;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.menu {
  border-right: none;
  margin-top: 10px;
}

.menu .el-menu-item {
  margin: 4px 8px;
  border-radius: 8px;
}

.menu .el-menu-item:hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.header {
  background-color: white;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.05);
}

.header-left {
  display: flex;
  align-items: center;
}

.breadcrumb-icon {
  font-size: 20px;
  color: #606266;
  cursor: pointer;
  transition: color 0.3s;
}

.breadcrumb-icon:hover {
  color: #409EFF;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 15px;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 8px;
}

.username {
  color: #606266;
  font-size: 14px;
}

.main-content {
  background-color: #f0f2f5;
  padding: 20px;
  overflow-y: auto;
}

.el-main {
  min-height: calc(100vh - 60px);
}

.el-card {
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.05);
  transition: all 0.3s;
}

.el-card:hover {
  box-shadow: 0 4px 16px 0 rgba(0, 0, 0, 0.1);
}

.el-button--primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border: none;
}

.el-button--primary:hover {
  opacity: 0.9;
  transform: translateY(-1px);
}

.el-table {
  border-radius: 8px;
  overflow: hidden;
}

.el-pagination {
  padding: 20px 0;
}
</style>
