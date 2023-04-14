import React from "react";
import { useNavigate } from "react-router-dom";
import CustomersList from "./customers-list.component";

const AdminBoard = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
        <h2>Admin Controls</h2>
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <button
          className="btn btn-primary"
          onClick={() => navigate("/add-product")}
        >
          Add New Product
        </button>
      </header>
      <CustomersList/>
    </div>
  );
};

export default AdminBoard;