import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import CartService from "../services/cart.service";
import './css/product-list.css';

function OrderList() {
  const [inactiveCarts, setInactiveCarts] = useState([]);

  useEffect(() => {
    async function fetchAllInactiveCarts() {
      try {
        const data = await CartService.GetAllInactiveCarts();
        setInactiveCarts(data);
      } catch (error) {
        console.log(error);
      }
    }

    fetchAllInactiveCarts();
  }, []);

  if (inactiveCarts.length === 0) {
    return (
      <main className="container">
        <h1>No any orders completed.</h1>
      </main>
    );
  }
    
  return (
    <main className="container">
  <h1>All Completed Orders History:</h1>
  <div className="row">
    {inactiveCarts.map((cart) => (
      <div key={cart.id} className="col-md-4 mb-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">Order Number: {cart.id}</h5>
            <p className="card-text"><b>Username:</b> {cart.user.username}</p>
            <p><b>Order Total Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(cart.totalPrice)}</p>
           
            {/* <p className="card-text"><b>Date of Purchase:</b>  </p> */}
            {/*    {cart.items[0].date}  */}
            
            <h6 className="card-subtitle mb-2 text-muted"><b>Order Items:</b></h6>
            <ul className="list-group">
            {cart.items.map((item) => (
  <li key={item.id} className="list-group-item">
    <p><b>Product Name:</b> {item.product.name}</p>
    <p><b>Product Price:</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(item.product.price)}</p>
    <p><b>Quantity:</b> {item.quantity}</p>
    {item && item.date && <p><b>Date:</b> {item.date}</p>}
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

export default OrderList;