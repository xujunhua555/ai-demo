import api from './index'

export default {
  getTimesheets() {
    return api.get('/timesheets')
  },
  
  getTimesheet(id) {
    return api.get(`/timesheets/${id}`)
  },
  
  createTimesheet(data) {
    return api.post('/timesheets', data)
  },
  
  updateTimesheet(id, data) {
    return api.put(`/timesheets/${id}`, data)
  },
  
  deleteTimesheet(id) {
    return api.delete(`/timesheets/${id}`)
  }
}
