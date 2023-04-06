import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/user-access/';

class UserService {

  getAllCustomersMethod() {
    return axios.get(API_URL + 'customers', { headers: authHeader() });
  }

  getCustomerByIdMethod(id) {
    return axios.get(API_URL + 'customers/' + id, { headers: authHeader() });
  }

  updateCustomerMethod(id, username, email, password, number, money, roles) {
    return axios.put(API_URL + 'customers/' + id, {
      username,
      email,
      password,
      number,
      money,
      roles
    }, { headers: authHeader() });
  }

  deleteCustomerMethod(id) {
    return axios.delete(API_URL + 'customers/' + id, { headers: authHeader() });
  }

  getCustomerBoardMethod() {
    return axios.get(API_URL + 'customer', { headers: authHeader() });
  }

  getManagerBoardMethod() {
    return axios.get(API_URL + 'manager', { headers: authHeader() });
  }

  getAdminBoardMethod() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();