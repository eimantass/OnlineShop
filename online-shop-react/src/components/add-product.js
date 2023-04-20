import React, { useState, useEffect } from "react";
import ProductService from "../services/product.service";
import PhotoService from "../services/photo.service";
import { useNavigate } from "react-router-dom";

function AddProductForm() {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [categories, setCategories] = useState([]);
  const [brand, setBrand] = useState("");
  const [brands, setBrands] = useState([]);
  const [description, setDescription] = useState("");
  const [photo, setPhoto] = useState(null); // Use null instead of an empty string for the photo state
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCategories = async () => {
      const response = await ProductService.getCategories();
      setCategories(response.data);
    };
    fetchCategories();
  }, []);

  useEffect(() => {
    const fetchBrands = async () => {
      const response = await ProductService.getBrands();
      setBrands(response.data);
    };
    fetchBrands();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const photoResponse = await PhotoService.uploadProductPhoto(photo); // Upload the photo first
      // const photoUrl = photoResponse.data.url; // Get the URL of the uploaded photo

      const photosResponse = await PhotoService.getAllPhotos();
      const photos = photosResponse.data;
      const lastPhoto = photos[photos.length - 1];

      const productData = {
        name: name,
        price: price,
        category: category,
        brand: brand,
        description: description,
        // photo: lastPhoto.id, // Use the URL of the uploaded photo in the product data
      };
  
      await ProductService.createProduct(productData); // Use the product data to create the product
  
      navigate("/");
    } catch (error) {
      console.log(error);
    }
  };


  return (
    <main>
      <h2 className="center">Add Product:</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
        </div>
        <div>
          <label htmlFor="price">Price:</label>
          <input
            type="text"
            id="price"
            name="price"
            value={price}
            onChange={(event) => setPrice(event.target.value)}
          />
        </div>
        <div>
          <label htmlFor="category">Category:</label>
          <select
            id="category"
            name="category"
            value={category}
            onChange={(event) => setCategory(event.target.value)}
          >
            <option value="">Select a category</option>
            {categories.map((category) => (
              <option key={category} value={category}>
                {category}
              </option>
            ))}
          </select>
        </div>
        <div>
          <label htmlFor="brand">Brand:</label>
          <select
            id="brand"
            name="brand"
            value={brand}
            onChange={(event) => setBrand(event.target.value)}
          >
            <option value="">Select a brand</option>
            {brands.map((brand) => (
              <option key={brand} value={brand}>
                {brand}
              </option>
            ))}
          </select>
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <textarea
            id="description"
            name="description"
            value={description}
            onChange={(event) => setDescription(event.target.value)}
          ></textarea>
        </div>
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
        <button type="submit">Save Product</button>
      </form>
    </main>
  );
}

export default AddProductForm