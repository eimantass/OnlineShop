import React, { useState, useEffect } from "react";
import CartService from "../services/cart.service";
import './css/product-list.css';

function ProductCart() {
  const [carts, setCarts] = useState([]);

  useEffect(() => {
    async function fetchCarts() {
      try {
        const currentUser = JSON.parse(localStorage.getItem('user'));
        const carts = await CartService.getAllCartsByUserId(currentUser.id);
        setCarts(carts);
      } catch (error) {
        console.log(error);
      }
    }

    fetchCarts();
  }, []);

  async function handleRemoveCart(cartId) {
    try {
      await CartService.deleteCartById(cartId);
      const newCarts = carts.filter((cart) => cart.id !== cartId);
      setCarts(newCarts);
    } catch (error) {
      console.log(error);
    }
  }

  async function handleRemoveItem(cartId, itemId) {
    await CartService.removeItemFromCart(cartId, itemId);
    const updatedCarts = await CartService.getAllCartsByUserId();
    setCarts(updatedCarts);
  }
  
  // render the list of carts
  return (
    <div>
      {carts.length > 0 ? (
        carts.map((cart) => (
          <div key={cart.id}>
            <h2>Cart Id: {cart.id}</h2>
            <button onClick={() => handleRemoveCart(cart.id)}>Remove Cart</button>
            <p>User Id: {cart.user.id}</p>
            <ul>
              {cart.items.map((item) => (
                <li key={item.id}>
                  <h3>{item.product.name}</h3>
                  <p>Quantity: {item.quantity}</p>
                  <p>Price: {item.product.price}</p>
                  <p>Total: {item.sum}</p>
                  <button onClick={() => handleRemoveItem(cart.id, item.id)}>Remove Item</button>
                </li>
              ))}
            </ul>
            <h3>Total Price: {cart.totalPrice}</h3>
          </div>
        ))
      ) : (
        <h2>No active carts for current user!</h2>
      )}
    </div>
  );
}

export default ProductCart;