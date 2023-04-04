import axios from "axios";
import AuthService from "./auth.service";

const API_URL = "http://localhost:8080/products";

const authInterceptor = config => {
  const user = AuthService.getCurrentUser();
  if (user && user.accessToken) {
    const token = "Bearer " + user.accessToken;
    config.headers.Authorization = token;
  }
  return config;
};

axios.interceptors.request.use(authInterceptor);

class ProductService {
  getAllProducts() {
    return axios.get(API_URL + "/all", { withCredentials: true });
  }

  getProductById(id) {
    return axios.get(API_URL + "/" + id);
  }

  createProduct(product) {
    return axios.post(API_URL + "/create", product);
  }

  updateProduct(id, product) {
    return axios.put(API_URL + "/" + id, product);
  }

  deleteProduct(id) {
    return axios.delete(API_URL + "/" + id);
  }
}

const productService = new ProductService();
export default productService;