import React from "react";
import { useNavigate } from "react-router-dom";

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
    </div>
  );
};

export default AdminBoard;