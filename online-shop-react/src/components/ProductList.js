import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import CartService from "../services/cart.service"; // Import CartService
import './css/product-list.css';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [selectedQuantity, setSelectedQuantity] = useState(1); // Add state for selected quantity
  const [cartMessage, setCartMessage] = useState(""); // Add state for cart message
  const navigate = useNavigate();

  // Fetch the all products data from repository
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

  const handleAddToCart = async (id, quantity) => {
    try {
      // Get the current user
      const currentUser = JSON.parse(localStorage.getItem('user'));
      
      // Check if the user has an active cart
      let cart = await CartService.getAllCartsByUserId(currentUser.id);
      
      // If the user does not have an active cart, create one
      if (!cart) {
        cart = await CartService.createCartByUserId(currentUser.id);
        setCartMessage("Cart created successfully!");
      } else {
        setCartMessage("You already have an active cart!");
      }
      
      // Add the product to the cart
      await CartService.addProductToCart(cart.id, id, quantity);
    } catch (error) {
      console.log(error);
    }
  };
  
  return (
    <main>
    <h2 className="text-center">Products List:</h2>
    {/* Products List from Repository */}
    <ul className="list-unstyled row">
      {products.map((product) => (
        <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
          <div className="product-image-container">
            <img src={product.photo} alt={product.name} className="product-image img-fluid" />
          </div>
          <h3 className="product-name">{product.name}</h3>
          <p>Description: {product.description}</p>
          <p>Category: {product.category}</p>
          {/* Display brands */}
          <p>Brand: {product.brand}</p>
          <p>Price: ${product.price}</p>
          {product.productParameters.length > 0 && (
            <ul>
              {product.productParameters.map((parameter) => (
                <li key={parameter.id}>
                  <p>
                    {parameter.name}: {parameter.description}
                  </p>
                </li>
              ))}
            </ul>
          )}
          {/* Select quantity */}
          {/* Input for quantity */}
          {/* Label for quantity */}
          <label>
            Quantity:
            <input
              type="number"
              value={product.quantity}
              onChange={(e) => {
                const newQuantity = parseInt(e.target.value);
                setProducts((prevProducts) =>
                  prevProducts.map((prevProduct) =>
                    prevProduct.id === product.id
                      ? { ...prevProduct, quantity: newQuantity }
                      : prevProduct
                  )
                );
              }}
              min={0}
              max={10}
              className="form-control"
            />
          </label>
          {/* Below each product an add to cart button */}
          <button
            className="btn btn-success"
            onClick={() => handleAddToCart(product.id, product.quantity)}
          >
            Add to Cart
          </button>
        </li>
      ))}
    </ul>
  </main>
  );
}

export default ProductList;