<template>
  <div class="roles">
    <el-card shadow="hover">
      <template #header>
        <div class="card-header">
          <span>角色管理</span>
          <el-button type="primary" @click="openAddDialog">添加角色</el-button>
        </div>
      </template>
      <el-table :data="roles" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="name" label="角色名称"></el-table-column>
        <el-table-column prop="description" label="角色描述"></el-table-column>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button type="primary" size="small" @click="openEditDialog(scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="deleteRole(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="dialogVisible" :title="dialogTitle" width="500px">
      <el-form :model="roleForm" label-width="80px">
        <el-form-item label="角色名称">
          <el-input v-model="roleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="角色描述">
          <el-input type="textarea" v-model="roleForm.description"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveRole">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import roleApi from '../api/role'
import { ElMessage } from 'element-plus'

export default {
  name: 'Roles',
  data() {
    return {
      roles: [],
      dialogVisible: false,
      dialogTitle: '添加角色',
      roleForm: {
        id: null,
        name: '',
        description: ''
      }
    }
  },
  mounted() {
    this.getRoles()
  },
  methods: {
    async getRoles() {
      try {
        this.roles = await roleApi.getRoles()
      } catch (error) {
        console.error('获取角色列表失败:', error)
      }
    },
    openAddDialog() {
      this.dialogTitle = '添加角色'
      this.roleForm = { id: null, name: '', description: '' }
      this.dialogVisible = true
    },
    openEditDialog(row) {
      this.dialogTitle = '编辑角色'
      this.roleForm = { ...row }
      this.dialogVisible = true
    },
    async saveRole() {
      try {
        if (this.roleForm.id) {
          await roleApi.updateRole(this.roleForm.id, this.roleForm)
          ElMessage.success('更新成功')
        } else {
          await roleApi.createRole(this.roleForm)
          ElMessage.success('添加成功')
        }
        this.dialogVisible = false
        this.getRoles()
      } catch (error) {
        ElMessage.error('操作失败')
      }
    },
    async deleteRole(id) {
      try {
        await roleApi.deleteRole(id)
        ElMessage.success('删除成功')
        this.getRoles()
      } catch (error) {
        ElMessage.error('删除失败')
      }
    }
  }
}
</script>

<style scoped>
.roles {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
