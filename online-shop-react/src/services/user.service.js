import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/user-access/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getCustomerBoard() {
    return axios.get(API_URL + 'customer', { headers: authHeader() });
  }

  getAllUsers() {
    return axios.get(API_URL + 'users', { headers: authHeader() });
  }


  getManagerBoard() {
    return axios.get(API_URL + 'manager', { headers: authHeader() });
  }
  getServiceManagerBoard() {
    return axios.get(API_URL + 'service-manager', { headers: authHeader() });
  }
 

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();