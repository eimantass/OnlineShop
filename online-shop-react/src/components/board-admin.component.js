import React from "react";
import { useNavigate } from "react-router-dom";

const AdminBoard = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <h2>Product Controls</h2>
        <button
          className="btn btn-info"
          onClick={() => navigate("/products")}
        >
          View All Products
        </button>
      </header>
      <h2>User Controls</h2>
      <button
          className="btn btn-warning"
          onClick={() => navigate("/users")}
        >
          View All Users
        </button>
        <button
          className="btn btn-primary"
          onClick={() => navigate("/admins")}
        >
          View All Admins
        </button>
        <button
          className="btn btn-success"
          onClick={() => navigate("/servicemanagers")}
        >
          View All Service Managers
        </button>
        <button
          className="btn btn-info"
          onClick={() => navigate("/managers")}
        >
          View All Managers
        </button>
        <button
          className="btn btn-danger"
          onClick={() => navigate("/customers")}
        >
          View All Customers
        </button>
        <h2>Cart Controls</h2>
        <button
          className="btn btn-danger"
          onClick={() => navigate("/carts")}
        >
          View All Carts
        </button>
        <h2>Order Controls</h2>
        <button
          className="btn btn-danger"
          onClick={() => navigate("/orders")}
        >
          View All Orders
        </button>
    </div>
  );
};

export default AdminBoard;