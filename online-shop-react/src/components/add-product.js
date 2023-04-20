import React, { useState, useEffect } from "react";
import ProductService from "../services/product.service";
import { useNavigate } from "react-router-dom";

function AddProductForm() {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [categories, setCategories] = useState([]);
  const [brand, setBrand] = useState(""); // Added brand state
  const [brands, setBrands] = useState([]); // Added brands state
  const [description, setDescription] = useState("");
  const [photo, setPhoto] = useState("");
  
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCategories = async () => {
      const response = await ProductService.getCategories(); // Fetch categories from API
      setCategories(response.data);
    };
    fetchCategories();
  }, []);
  useEffect(() => {
    const fetchBrands = async () => {
      const response = await ProductService.getBrands(); // Fetch brands from API
      setBrands(response.data);
    };
    fetchBrands();
  }, []);
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const product = {
        name,
        price,
        category: category, //  Product object category 
        brand: brand, //  Product object brand
        description,
        photo,
      };
      console.debug("product: ", product.name, product.price, product.category, product.brand, product.description, product.photo);
      await ProductService.createProduct(product);

     
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
        <label htmlFor="brand">Brand:</label> {/* Added brand select input */}
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
        <label htmlFor="photo">Photo:</label>
        <input
          type="text"
          id="photo"
          name="photo"
          value={photo}
          onChange={(event) => setPhoto(event.target.value)}
        />
      </div>
      <button type="submit">Save Product</button>
    </form>
  </main>
);
}
export default AddProductForm;