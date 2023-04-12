import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/user-access/';

class UserService {

  // Get all customers from repository

  getAllCustomersMethod() {
    return axios.get(API_URL + 'customers', { headers: authHeader() });
  }

  // Get all roles from repository

  getAllRolesMethod() {
    return axios.get(API_URL + 'roles', { headers: authHeader() });
  }

  // Get role by user ID
  getRolesByUserIdMethod(userId) {
     return axios.get(API_URL + `roles/user/${userId}`, { headers: authHeader() });
  }
  

  getCustomerByIdMethod(id) {
    return axios.get(API_URL + 'customers/' + id, { headers: authHeader() });
  }

  updateCustomerMethod(id, user) {
    return axios.put(API_URL + 'customer/' + id, user, 
   { headers: authHeader() });
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