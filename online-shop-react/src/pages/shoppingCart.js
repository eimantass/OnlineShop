import React, { useState } from "react";

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
      <h2>Product Cart</h2>
      {cartItems.length === 0 ? (
        <p>No items in the cart.</p>
      ) : (
        <ul>
          {cartItems.map((item, index) => (
            <li key={index}>
              <h3>{item.name}</h3>
              <p>Quantity: {item.quantity}</p>
              <p>Price: ${item.price}</p>
              <p>Subtotal: ${item.price * item.quantity}</p>
            </li>
          ))}
          <li>
            <h3>Total:</h3>
            <p>${calculateTotalPrice()}</p>
          </li>
        </ul>
      )}
      <button onClick={handleClearCart}>Clear Cart</button>
    </main>
  );
}

export default ProductCart;