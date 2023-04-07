import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ProductService from "../services/product.service";

function UpdateProduct() {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const [categories, setCategories] = useState([]);
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [productResponse, categoriesResponse] = await Promise.all([
          ProductService.getProductById(id),
          ProductService.getCategories(),
        ]);
        setProduct(productResponse.data);
        setCategories(categoriesResponse.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [id]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setProduct((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
  
    try {
      const { id, category, ...productData } = product;
      const existingCategory = await ProductService.getCategories(category.id);
      const updatedProduct = { ...productData, category: existingCategory };
      await ProductService.updateProduct(id, updatedProduct);
      setMessage("The product was updated successfully!");
      navigate("/home");
    } catch (error) {
      setMessage("Something went wrong. Please try again later.");
      console.log(error);
    }
  };

  return (
    <main>
      <h2 className="center">Update Product:</h2>
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            id="name"
            type="text"
            name="name"
            value={product.name || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="price">Price:</label>
          <input
            id="price"
            type="number"
            name="price"
            value={product.price || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <textarea
            id="description"
            name="description"
            value={product.description || ''}
            onChange={handleInputChange}
          ></textarea>
        </div>
        <div>
          <label htmlFor="discount">Discount:</label>
          <input
            id="discount"
            type="number"
            name="discount"
            value={product.discount || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="photo">Photo:</label>
          <input
            id="photo"
            type="text"
            name="photo"
            value={product.photo || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="category">Category:</label>
          <select
  id="category"
  name="category"
  value={product.category ? product.category.id : ''}
  onChange={handleInputChange}
>
  <option value="">Select a category</option>
  {categories.map((category) => (
    <option key={category.id} value={category.id}>
      {category.name}
    </option>
  ))}
</select>
        </div>
        <button type="submit">Save Changes</button>
      </form>
    </main>
  );
}

export default UpdateProduct;