import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ProductService from "../services/product.service";

function UpdateProductPrice() {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [productResponse] = await Promise.all([
          ProductService.getProductById(id), // Fetching name, price, description, photo from API
        ]);
        setProduct(productResponse.data);
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
      [name]: name === "brand" ? String(value) : value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const { id, ...productData } = product;
      const updatedProduct = { ...productData };
      await ProductService.updateProduct(id, updatedProduct);
      setMessage("The product price was updated successfully! You will be automatically redirected back");
      setTimeout(() => {
        navigate("/manager-products");
      }, 2000); // Redirect after 2 second
    } catch (error) {
      setMessage("Could not update the product. Please try again.");
      console.log(error);
    }
  };

  return (
    // Manager Update only the Price of the Product
    <main>
      <h3>Product name: {product.name || ""} </h3>
      {/* Display current price: */}
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="price">Update Price:</label>
          <input
            id="price"
            type="number"
            name="price"
            value={product.price || ""}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Update Product Price</button>
      </form>
    </main>
  );
}

export default UpdateProductPrice;