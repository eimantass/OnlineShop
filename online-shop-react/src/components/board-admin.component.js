import React from "react";
import { useNavigate } from "react-router-dom";
import CustomersList from "./customers-list.component";

const AdminBoard = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <h2>Product Controls</h2>
        <button
          className="btn btn-primary"
          onClick={() => navigate("/add-product")}
        >
          Add New Product
        </button>
        <button
          className="btn btn-info"
          onClick={() => navigate("/products")}
        >
          View All Products
        </button>
      </header>
      <CustomersList/>
    </div>
  );
};

export default AdminBoard;