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

  // render the list of carts
  return (
    <div>
    {carts.length > 0 ? (
      carts.map((cart) => (
        <div key={cart.id}>
          <h2>Cart Id: {cart.id}</h2>
          <p>User Id: {cart.user.id}</p> {/* extract the userId from the user object */}
        </div>
      ))
    ) : (
      <h2>No active carts for current user!</h2>
    )}
  </div>
  );
}

export default ProductCart;