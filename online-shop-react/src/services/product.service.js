import axios from "axios";
import authHeader from './auth-header';

const API_URL = "http://localhost:8080/products";

const authInterceptor = config => {
  const headers = authHeader();
  if (headers.Authorization) {
    config.headers = headers;
  }
  return config;
};

axios.interceptors.request.use(authInterceptor);

class ProductService {
  getAllProducts() {
    return axios.get(API_URL + "/all", { withCredentials: true });
  }

  getProductById(id) {
    return axios.get(API_URL + "/" + id, { headers: authHeader() });
  }

  createProduct(product) {
    return axios.post(API_URL + "/create", product, { headers: authHeader() });
  }

  updateProduct(id, product) {
    return axios.put(API_URL + "/" + id, product, { headers: authHeader() });
  }

  deleteProduct(id) {
    return axios.delete(API_URL + "/delete/" + id, { headers: authHeader() });
  }
}

export default new ProductService();