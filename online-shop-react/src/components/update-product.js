import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ProductService from "../services/product.service";

function UpdateProduct() {
  const { id } = useParams();
  const [product, setProduct] = useState({
    name: "",
    price: "",
    description: "",
    discount: "",
    photo: "",
  });
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await ProductService.getProductById(id);
        setProduct(response.data);
      } catch (error) {
        console.log(error);
      }
    }
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
      await ProductService.updateProduct(id, product);
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
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={product.name}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Price:</label>
          <input
            type="number"
            name="price"
            value={product.price}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            name="description"
            value={product.description}
            onChange={handleInputChange}
          ></textarea>
        </div>
        <div>
          <label>Discount:</label>
          <input
            type="number"
            name="discount"
            value={product.discount}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Photo:</label>
          <input
            type="text"
            name="photo"
            value={product.photo}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Save Changes</button>
      </form>
    </main>
  );
}

export default UpdateProduct;