import React, { useState } from "react";
import './css/product-list.css';

function ProductCart() {
  const [cartItems, setCartItems] = useState([]);

  // Calculate total price
  const calculateTotalPrice = () => {
    let totalPrice = 0;
    cartItems.forEach((item) => {
      totalPrice += item.price * item.quantity;
    });
    return totalPrice;
  };

  // Clear Cart
  const handleClearCart = () => {
    setCartItems([]);
  };

  return (
    <main>
      <body>
       <h2>Test</h2> 
      </body>
    </main>
  );
}

export default ProductCart;