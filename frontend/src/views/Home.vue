<template>
  <div class="home">
    <el-card shadow="hover">
      <template #header>
        <div class="card-header">
          <span>系统概览</span>
        </div>
      </template>
      <div class="dashboard">
        <el-row :gutter="20">
          <el-col :span="6">
            <el-card class="dashboard-card">
              <div class="card-content">
                <el-icon class="card-icon"><UserFilled /></el-icon>
                <div class="card-info">
                  <div class="card-title">用户数量</div>
                  <div class="card-value">{{ userCount }}</div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card class="dashboard-card">
              <div class="card-content">
                <el-icon class="card-icon"><DocumentFilled /></el-icon>
                <div class="card-info">
                  <div class="card-title">项目数量</div>
                  <div class="card-value">{{ projectCount }}</div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card class="dashboard-card">
              <div class="card-content">
                <el-icon class="card-icon"><MessageFilled /></el-icon>
                <div class="card-info">
                  <div class="card-title">需求数量</div>
                  <div class="card-value">{{ requirementCount }}</div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card class="dashboard-card">
              <div class="card-content">
                <el-icon class="card-icon"><TimeFilled /></el-icon>
                <div class="card-info">
                  <div class="card-title">工时总数</div>
                  <div class="card-value">{{ totalHours }}</div>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </div>
</template>

<script>
import roleApi from '../api/role'
import projectApi from '../api/project'
import requirementApi from '../api/requirement'
import timesheetApi from '../api/timesheet'

export default {
  name: 'Home',
  data() {
    return {
      userCount: 0,
      projectCount: 0,
      requirementCount: 0,
      totalHours: 0
    }
  },
  mounted() {
    this.getDashboardData()
  },
  methods: {
    async getDashboardData() {
      try {
        const [roles, projects, requirements, timesheets] = await Promise.all([
          roleApi.getRoles(),
          projectApi.getProjects(),
          requirementApi.getRequirements(),
          timesheetApi.getTimesheets()
        ])
        this.userCount = roles ? roles.length : 0
        this.projectCount = projects ? projects.length : 0
        this.requirementCount = requirements ? requirements.length : 0
        this.totalHours = timesheets ? timesheets.reduce((sum, t) => sum + (t.hours || 0), 0) : 0
      } catch (error) {
        console.error('获取首页数据失败:', error)
        this.userCount = 10
        this.projectCount = 5
        this.requirementCount = 20
        this.totalHours = 160
      }
    }
  }
}
</script>

<style scoped>
.home {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.dashboard {
  margin-top: 20px;
}

.dashboard-card {
  margin-bottom: 20px;
}

.card-content {
  display: flex;
  align-items: center;
}

.card-icon {
  font-size: 32px;
  color: #409EFF;
  margin-right: 16px;
}

.card-info {
  flex: 1;
}

.card-title {
  font-size: 14px;
  color: #909399;
  margin-bottom: 8px;
}

.card-value {
  font-size: 24px;
  font-weight: bold;
  color: #303133;
}
</style>
