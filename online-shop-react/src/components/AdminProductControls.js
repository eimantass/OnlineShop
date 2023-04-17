import React from "react";
import { useNavigate } from "react-router-dom";
import AdminProductList from "./AdminProductList";

const AdminProductControls = () => {
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
        <button
          className="btn btn-warning"
          onClick={() => navigate("/admin")}
        >
          Back
        </button>
      </header>
      <AdminProductList/>
      
      
    </div>
  );
};

export default AdminProductControls;