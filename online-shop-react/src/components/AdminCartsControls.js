import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import CartService from "../services/cart.service";

const AdminCartsControls = () => {
  const navigate = useNavigate();
  const [carts, setCarts] = useState([]);

  useEffect(() => {
    async function fetchCarts() {
      try {
        const carts = await CartService.GetAllCarts();
        setCarts(carts);
      } catch (error) {
        console.log(error);
      }
    }

    fetchCarts();
  }, []);

  const handleRemoveItem = async (cartId, itemId) => {
    try {
      await CartService.removeItemFromCart(cartId, itemId);
      const updatedCarts = await CartService.getAllCartsByUserId();
      setCarts(updatedCarts);
    } catch (error) {
      console.log(error);
    }
  };

  async function handleRemoveCart(cartId) {
    try {
      await CartService.deleteCartById(cartId);
      const updatedCarts = await CartService.getAllCartsByUserId();
      setCarts(updatedCarts);
    } catch (error) {
      console.log(error);
    }
  }


  return (
         
 <div>
    <button
          className="btn btn-warning"
          onClick={() => navigate("/admin")}
          > Back </button>
 {carts.length > 0 ? (
   carts.map((cart) => (
     <div key={cart.id}>
       <h2>Cart Id: {cart.id}</h2>
       <p>User Id: {cart.user.id}</p>
       <button
              className="btn btn-danger"
              onClick={() => handleRemoveCart(cart.id)}
            >
              Remove Cart
            </button>
       <ul>
         {cart.items.map((item) => (
           <li key={item.id}>
             <h3>{item.product.name}</h3>
             <p>Quantity: {item.quantity}</p>
             <p>Price: {item.product.price}</p>
             <p>Total: {item.sum}</p>
             <button
                    className="btn btn-warning"
                    onClick={() => handleRemoveItem(cart.id, item.id)}
                  >
                    Remove Item
                  </button>
           </li>
         ))}
       </ul>
       <h3>Total Price: {cart.totalPrice}</h3>
     </div>
   ))
 ) : (
   <h2>No carts available!</h2>
 )}
</div>


  );
};

export default AdminCartsControls;