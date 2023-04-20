import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import PhotoService from "../services/photo.service";
import "./css/product-list.css";

function AdminProductPhotoControls() {
    const [photos, setPhotos] = useState([]);
const [photoUrl, setPhotoUrl] = useState("");
  const [products, setProducts] = useState([]);
  const [photoIds, setPhotoIds] = useState([]); // Add photoIds state
 
  const [photo, setPhoto] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await ProductService.getAllProducts();
        setProducts(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await PhotoService.getAllPhotos();
        setPhotos(response.data);

        // Extract the IDs of all photos
        const ids = response.data.map((photo) => photo.id);
        setPhotoIds(ids);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const photoResponse = await PhotoService.uploadProductPhoto(photo);
      const photoUrl = photoResponse.data.filename;
  
      const photoIdsResponse = await PhotoService.getAllPhotoIds();
      const photoIds = photoIdsResponse.data;
  
      const photosResponse = await Promise.all(
        photoIds.map((id) => PhotoService.getPhotoById(id))
      );
      const photos = photosResponse.map((response) => response.data);
  
      setPhotos(photos);
      setPhotoUrl(photoUrl);
    } catch (error) {
      console.log(error);
    }
  };

  const handleGetPhotoById = async (id) => {
    try {
      const response = await PhotoService.getPhotoById(id);
      console.log(response.data); // Display the details of the fetched photo
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <main>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="photo">Image:</label>
          <input
            id="photo"
            name="photo"
            type="file"
            accept=".jpg,.jpeg,.png,.gif"
            onChange={(event) => {
              const selectedFile = event.target.files[0];
              setPhoto(selectedFile);
            }}
          />
        </div>
        <button type="submit">Save Photo</button>
      </form>

      {/* Render all photo IDs */}
      <div>
    {photos.map((photo) => (
      <div key={photo._id}>
        <img src={photoUrl + photo.filename} alt={photo.description} />
      </div>
    ))}
  </div>
    </main>
  );
}

export default AdminProductPhotoControls;