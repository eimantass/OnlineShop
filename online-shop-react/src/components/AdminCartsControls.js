import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import CartService from "../services/cart.service";
import './css/product-list.css';

function AdminCartsControls() {
  const navigate = useNavigate();
  const [carts, setCarts] = useState([]);

  useEffect(() => {
    async function fetchCarts() {
      try {
        const carts = await CartService.GetAllActiveCarts();
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
      const updatedCarts = await CartService.GetAllActiveCarts();
      setCarts(updatedCarts);
      window.location.reload();
    } catch (error) {
      console.log(error);
    }
  };

  async function handleRemoveCart(cartId) {
    try {
      await CartService.deleteCartById(cartId);
      const updatedCarts = await CartService.GetAllActiveCarts();
      setCarts(updatedCarts);
      window.location.reload();
    } catch (error) {
      console.log(error);
    }
  }


  return (
    <main className="container">
      <button
        className="btn btn-warning"
        onClick={() => navigate("/admin")}
      >
        Back
      </button>
      <h1>Active Carts (Incomplete orders)</h1>
      {carts.length > 0 ? (
        <div className="row">
          {carts.map((cart) => (
            <div key={cart.id} className="col-md-4 mb-4">
              <div className="card">
                <div className="card-body">
                  <h5 className="card-title">Cart Id: {cart.id}</h5>
                  <p className="card-text"><b>User Id:</b> {cart.user.id}</p>
                  <p className="card-text"><b>Username:</b> {cart.user.username}</p>
                  <button
                    className="btn btn-danger"
                    onClick={() => handleRemoveCart(cart.id)}
                  >
                    Remove Cart
                  </button>
                  <ul className="list-group">
                    {cart.items.map((item) => (
                      <li key={item.id} className="list-group-item">
                        <h6><b>Product Name:</b> {item.product.name}</h6>
                        <p><b>Quantity:</b> {item.quantity}</p>
                        <p><b>Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(item.product.price)}</p>
                        <p><b>Total:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(item.sum)}</p>
                        <button
                          className="btn btn-warning"
                          onClick={() => handleRemoveItem(cart.id, item.id)}
                        >
                          Remove Item
                        </button>
                      </li>
                    ))}
                  </ul>
                  <h6 className="card-subtitle mb-2 text-muted"><b>Total Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(cart.totalPrice)}</h6>
                </div>
              </div>
            </div>
          ))}
        </div>
      ) : (
        <h2>No carts available!</h2>
      )}
    </main>
  );
}

export default AdminCartsControls;