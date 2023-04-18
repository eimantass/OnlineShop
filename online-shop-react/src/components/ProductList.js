import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import CartService from "../services/cart.service";
import './css/product-list.css';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [cartMessage, setCartMessage] = useState("");
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

  const handleAddToCart = async (product) => {
    try {
      const currentUser = JSON.parse(localStorage.getItem('user'));
      let carts = await CartService.getAllCartsByUserId(currentUser.id);
      // If user doesnt have a cart - create it
      if (!carts || carts.length === 0) {
        carts = await CartService.createCartByUserId(currentUser.id);
        setCartMessage("Cart created successfully!");
      } else {
        setCartMessage("You already have an active cart!");
      }
      // Check again for carts as per userID
      let carts2 = await CartService.getAllCartsByUserId(currentUser.id);

    // Sort the carts by createdAt field in descending order
    carts2 = carts2.sort((a, b) => {
      if (a.createdAt > b.createdAt) return -1;
      if (a.createdAt < b.createdAt) return 1;
      return 0;
    });
    // We select the latest cart we get from carts list of the user and assign it
    let cart;
    cart = carts2[0];

    // Construct the data to be sent in the request body
    // JUST FOR DEBUGGING 
    const data = {
      productId: product.id,
      quantity: product.selectedQuantity,
      cartId: cart.id
    };
    
    console.debug("Sending JSON: ", data);

      await CartService.addItemToCart(cart.id, product.id, product.selectedQuantity);
    } catch (error) {
      console.log(error);
    }
  };
  
  const handleQuantityChange = (product, newQuantity) => {
    setProducts((prevProducts) =>
      prevProducts.map((prevProduct) =>
        prevProduct.id === product.id
          ? { ...prevProduct, selectedQuantity: newQuantity }
          : prevProduct
      )
    );
  };

  return (
    <main>
      <h2 className="text-center">Products List:</h2>
      <ul className="list-unstyled row">
        {products.map((product) => (
          <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
            <div className="product-image-container">
              <img src={product.photo} alt={product.name} className="product-image img-fluid" />
            </div>
            <h3 className="product-name">{product.name}</h3>
            <p>Description: {product.description}</p>
            <p>Category: {product.category}</p>
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
            <label>
              Quantity:
              <input
                type="number"
                value={product.selectedQuantity}
                onChange={(e) => handleQuantityChange(product, parseInt(e.target.value))}
                min={0}
                max={10}
                className="form-control"
              />
            </label>
            <button
              className="btn btn-success"
              onClick={() => handleAddToCart(product)}
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