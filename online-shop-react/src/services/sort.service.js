import axios from "axios";
import authHeader from './auth-header';

const API_URL = "http://localhost:8080";

const authInterceptor = config => {
  const headers = authHeader();
  if (headers.Authorization) {
    config.headers = headers;
  }
  return config;
};

axios.interceptors.request.use(authInterceptor);

class SortService {
// Sort by Processor category method retrieve API
sortByProcessor() {
   return axios.get(API_URL + "/products/filter-by-category/PROCESSORS", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
      console.error("Failed to retrieve sorted products by category:", error);
      throw error; // Propagate the error for handling in the calling code
      });
  }
// Sort by Laptop category method to retrieve API
sortByLaptop() {
   return axios.get(API_URL + "/products/filter-by-category/LAPTOPS", { withCredentials: true })
     .then(response => response.data) // Extract data from response
     .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by GraphicsCards category method to retrieve API
sortByGraphicsCards() {
  return axios.get(API_URL + "/products/filter-by-category/GRAPHICS_CARDS", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Mainboards category method to retrieve API
sortByMainboards() {
  return axios.get(API_URL + "/products/filter-by-category/MAINBOARDS", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Mobile Phones category method to retrieve API
sortByMobilePhones() {
  return axios.get(API_URL + "/products/filter-by-category/MOBILE_PHONES", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Monitors category method to retrieve API
sortByMonitors() {
  return axios.get(API_URL + "/products/filter-by-category/MONITORS", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Printers category method to retrieve API
sortByPrinters() {
  return axios.get(API_URL + "/products/filter-by-category/PRINTERS", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Consoles category method to retrieve API
sortByConsoles() {
  return axios.get(API_URL + "/products/filter-by-category/GAMECONSOLES", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
// Sort by Consoles category method to retrieve API
sortByGames() {
  return axios.get(API_URL + "/products/filter-by-category/GAMES", { withCredentials: true })
    .then(response => response.data) // Extract data from response
    .catch(error => {
       console.error("Failed to retrieve sorted products by category:", error);
       throw error; // Propagate the error for handling in the calling code
       });
  }
}

export default new SortService();