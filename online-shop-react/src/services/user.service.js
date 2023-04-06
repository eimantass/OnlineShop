import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/user-access/';

class UserService {

  getCustomerBoardMethod() {
    return axios.get(API_URL + 'customer', { headers: authHeader() });
  }

  getAllCustomersMethod() {
    return axios.get(API_URL + 'customers', { headers: authHeader() });
  }

  getManagerBoardMethod() {
    return axios.get(API_URL + 'manager', { headers: authHeader() });
  }

  getAdminBoardMethod() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();