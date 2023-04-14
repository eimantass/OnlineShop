import React from "react";
import { useNavigate } from "react-router-dom";
import ManagerProductList from "./ManagerProductList";

const ManagerProductControls = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
      <header className="jumbotron">
        {/* Render "Add New Product" button */}
        <h2>Product Controls</h2>
    
        <button
          className="btn btn-warning"
          onClick={() => navigate("/manager")}
        >
          Back
        </button>
      </header>
      <ManagerProductList/>
      
      
    </div>
  );
};

export default ManagerProductControls;