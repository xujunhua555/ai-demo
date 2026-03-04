import api from './index'

export default {
  getDashboardData() {
    return api.get('/dashboard')
  }
}
