import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/user-access/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'users', { headers: authHeader() });
  }

  getAllUsers() {
    return axios.get(API_URL + 'users', { headers: authHeader() });
  }


  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

 

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();