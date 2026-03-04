import api from './index'

export default {
  getRequirements() {
    return api.get('/requirements')
  },
  
  getRequirement(id) {
    return api.get(`/requirements/${id}`)
  },
  
  createRequirement(data) {
    return api.post('/requirements', data)
  },
  
  updateRequirement(id, data) {
    return api.put(`/requirements/${id}`, data)
  },
  
  deleteRequirement(id) {
    return api.delete(`/requirements/${id}`)
  }
}
