import React, { useState, useEffect } from "react";
import ProductService from "../services/product.service";
import { useNavigate } from "react-router-dom";

function AddProductForm() {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [description, setDescription] = useState("");
  const [photo, setPhoto] = useState("");
  const [categories, setCategories] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCategories = async () => {
      const response = await ProductService.getCategories();
      setCategories(response.data);
    };
    fetchCategories();
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const product = {
        name,
        price,
        category: { id: category },
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
              <option key={category.id} value={category.id}>
                {category.name}
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