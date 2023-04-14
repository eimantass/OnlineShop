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

  // Function to validate URL
const isValidUrl = (url) => {
  // Regular expression to validate URL
  const urlRegex = /^(ftp|http|https):\/\/[^ "]+$/;
  return urlRegex.test(url);
};

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
  <label htmlFor="photo">Image: (Only links to images: jpg,jpeg,png,gif)</label>
  <input
    id="photo"
    name="photo"
    value={photo}
    type="url" /* Change input type to "url" to enforce URL validation */
    pattern=".*\.(jpg|jpeg|png|gif)" /* Use "pattern" attribute with a regex to validate image file extensions */
    onChange={(event) => {
      const inputValue = event.target.value;
      const isValidLink = isValidUrl(inputValue); // Add a function to validate URL
      if (isValidLink || inputValue === "") {
        setPhoto(inputValue);
      }
    }}
  />
</div>
        <button type="submit">Save Product</button>
      </form>
    </main>
  );
}

export default AddProductForm;