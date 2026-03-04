import api from './index'

export default {
  login(data) {
    return api.post('/auth/login', data)
  },
  
  getUsers() {
    return api.get('/users')
  },
  
  createUser(data) {
    return api.post('/users', data)
  },
  
  updateUser(id, data) {
    return api.put(`/users/${id}`, data)
  },
  
  deleteUser(id) {
    return api.delete(`/users/${id}`)
  }
}
