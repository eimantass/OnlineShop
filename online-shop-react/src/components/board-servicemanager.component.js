import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const ServiceManagerBoard = () => {
    const navigate = useNavigate();
  

  return (
    <div className="container">
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <h2>Customer Controls</h2>

        <button
          className="btn btn-info"
          onClick={() => navigate("/servicemanager-customers")}
        >
          View All Customers
        </button>
      </header>
    
    </div>
  );
};

export default ServiceManagerBoard;