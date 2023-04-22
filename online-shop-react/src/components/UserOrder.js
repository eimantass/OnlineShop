import React, { useEffect, useState } from "react";
import './css/product-list.css';
import CartService from "../services/cart.service";
import UserService from "../services/user.service";

function UserOrder() {
  const [inactiveCarts, setInactiveCarts] = useState([]);
  const currentUser = JSON.parse(localStorage.getItem('user'));

  useEffect(() => {
    async function fetchInactiveCarts() {
      try {
        const data = await CartService.GetInactiveCarts(currentUser.id);
        setInactiveCarts(data);
      } catch (error) {
        console.log(error);
      }
    }

    fetchInactiveCarts();
  }, []);
    

  return (
<main className="container">
  <h1>Order History:</h1>
  <div className="row">
    {inactiveCarts.map((cart) => (
      <div key={cart.id} className="col-md-4 mb-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">Order Number: {cart.id}</h5>
            <p className="card-text"><b>Username:</b> {cart.user.username}</p>
            <p><b>Order Total Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(cart.totalPrice)}</p>
            <p className="card-text"><b>Date of Purchase:</b> {cart.items[0].date}</p>
            <h6 className="card-subtitle mb-2 text-muted"><b>Order Items:</b></h6>
            <ul className="list-group">
              {cart.items.map((item) => (
                <li key={item.id} className="list-group-item">
                  <p><b>Product Name:</b> {item.product.name}</p>
                  <p><b>Product Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(item.product.price)}</p>
                  <p><b>Quantity:</b> {item.quantity}</p>
                  {/* display other item details */}
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    ))}
  </div>
</main>
  );
}

export default UserOrder;