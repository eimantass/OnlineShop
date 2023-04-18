import React, { useState, useEffect } from "react";
import CartService from "../services/cart.service";
import UserService from "../services/user.service";
import AuthService from "../services/auth.service";
import { Link } from "react-router-dom";
import './css/product-list.css';

function ProductCart() {
  const [content, setContent] = useState("");
  const [carts, setCarts] = useState([]);
  const [customerData, setCustomerData] = useState([]);
  const currentUser = AuthService.getCurrentUser();

  useEffect(() => {
    async function fetchData() {
      try {
        const user = JSON.parse(localStorage.getItem('user'));
        const carts = await CartService.getAllCartsByUserId(user.id);
        setCarts(carts);
      } catch (error) {
        console.log(error);
      }
    }

    fetchData();
  }, []);

  useEffect(() => {
    const currentUser = AuthService.getCurrentUser();
    if (currentUser) {
      // Fetch customer data using the current user ID
      UserService.getCustomerByIdMethod(currentUser.id)
        .then((response) => {
          setCustomerData(response.data);
        })
        .catch((error) => {
          setContent(
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
              error.message ||
              error.toString()
          );
        });
    } else {
      // Handle case when no current user is available
      setContent("No current user found.");
    }
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
    const updatedCarts = await CartService.getAllCartsByUserId(currentUser.id);
    setCarts(updatedCarts);
  }

  async function handleUpdateQuantity(cartId, itemId, itemQuantity) {
    try {
      const updatedCart = await CartService.UpdateItemQuantityInCart(cartId, itemId, itemQuantity);
      console.log(updatedCart);
      console.debug("UPDT CART: ", updatedCart);
      
      const updatedCarts = await CartService.getAllCartsByUserId(currentUser.id);
      setCarts(updatedCarts);
    } catch (error) {
      console.log(error);
    }
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
                  <label>
                      Quantity:
                      <input type="number" value={item.quantity} 
                      onChange={(event) => handleUpdateQuantity(cart.id, item.id, event.target.value)} min="1" max="10" />
                    </label>
                  <p>Price: {item.product.price}</p>
                  <p>Total: {item.sum}</p>
                  <button onClick={() => handleRemoveItem(cart.id, item.id)}>Remove Item</button>
                </li>
              ))}
            </ul>
            <h3>Total Price of Cart Products: {cart.totalPrice}</h3>
            {currentUser && <h3>Your Wallet: {customerData.money}</h3>}
            {/* <button onClick={handlePurchase}>Purchase</button> */}
            <button className="btn btn-primary btn-lg" type="button">Purchase</button>
          </div>
        ))
      ) : (
        <h2>No active carts for current user!</h2>
      )}
    </div>
  );
}

export default ProductCart;