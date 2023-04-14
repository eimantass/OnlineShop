import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const ManagerBoard = () => {
    const navigate = useNavigate();
  

  return (
    <div className="container">
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <h2>Product Controls</h2>

        <button
          className="btn btn-info"
          onClick={() => navigate("/manager-products")}
        >
          View All Products
        </button>
      </header>
    
    </div>
  );
};

export default ManagerBoard;