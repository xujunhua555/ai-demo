<template>
  <div class="projects">
    <el-card shadow="hover">
      <template #header>
        <div class="card-header">
          <span>项目管理</span>
          <el-button type="primary" @click="openAddDialog">添加项目</el-button>
        </div>
      </template>
      <el-table :data="projects" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="name" label="项目名称"></el-table-column>
        <el-table-column prop="description" label="项目描述"></el-table-column>
        <el-table-column prop="status" label="状态" width="120">
          <template #default="scope">
            <el-tag :type="scope.row.status === 1 ? 'success' : 'info'">
              {{ scope.row.status === 1 ? '进行中' : '已完成' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button type="primary" size="small" @click="openEditDialog(scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="deleteProject(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="dialogVisible" :title="dialogTitle" width="500px">
      <el-form :model="projectForm" label-width="80px">
        <el-form-item label="项目名称">
          <el-input v-model="projectForm.name"></el-input>
        </el-form-item>
        <el-form-item label="项目描述">
          <el-input type="textarea" v-model="projectForm.description"></el-input>
        </el-form-item>
        <el-form-item label="项目状态">
          <el-radio-group v-model="projectForm.status">
            <el-radio :label="1">进行中</el-radio>
            <el-radio :label="0">已完成</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveProject">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import projectApi from '../api/project'
import { ElMessage } from 'element-plus'

export default {
  name: 'Projects',
  data() {
    return {
      projects: [],
      dialogVisible: false,
      dialogTitle: '添加项目',
      projectForm: {
        id: null,
        name: '',
        description: '',
        status: 1
      }
    }
  },
  mounted() {
    this.getProjects()
  },
  methods: {
    async getProjects() {
      try {
        this.projects = await projectApi.getProjects()
      } catch (error) {
        console.error('获取项目列表失败:', error)
      }
    },
    openAddDialog() {
      this.dialogTitle = '添加项目'
      this.projectForm = { id: null, name: '', description: '', status: 1 }
      this.dialogVisible = true
    },
    openEditDialog(row) {
      this.dialogTitle = '编辑项目'
      this.projectForm = { ...row }
      this.dialogVisible = true
    },
    async saveProject() {
      try {
        if (this.projectForm.id) {
          await projectApi.updateProject(this.projectForm.id, this.projectForm)
          ElMessage.success('更新成功')
        } else {
          await projectApi.createProject(this.projectForm)
          ElMessage.success('添加成功')
        }
        this.dialogVisible = false
        this.getProjects()
      } catch (error) {
        ElMessage.error('操作失败')
      }
    },
    async deleteProject(id) {
      try {
        await projectApi.deleteProject(id)
        ElMessage.success('删除成功')
        this.getProjects()
      } catch (error) {
        ElMessage.error('删除失败')
      }
    }
  }
}
</script>

<style scoped>
.projects {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
