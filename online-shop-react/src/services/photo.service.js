import axios from "axios";
import authHeader from './auth-header';

const API_URL = "http://localhost:8080/photo";

const authInterceptor = config => {
  const headers = authHeader();
  if (headers.Authorization) {
    config.headers = headers;
  }
  return config;
};

axios.interceptors.request.use(authInterceptor);

class PhotoService {
  // Upload Photo
  uploadProductPhoto(file) {
    const formData = new FormData();
    formData.append("file", file);
    return axios.post(API_URL, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
  }

  // Get All Photos
  getAllPhotos() {
    return axios.get(API_URL + "/allPhotos", { withCredentials: true });
  }

  // Delete Photo
  deletePhotoById(id) {
    return axios.delete(API_URL + "/" + id);
  }
}

export default new PhotoService();