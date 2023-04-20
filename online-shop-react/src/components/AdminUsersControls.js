import React from "react";
import CustomersList from "./customers-list.component";
import { useNavigate } from "react-router-dom";

const AdminUsersControls = () => {

  const navigate = useNavigate();
  
  return (
    <div className="container">
          <button
          className="btn btn-warning"
          onClick={() => navigate("/admin")}
          > Back </button>
      
      <CustomersList/>
    </div>
  );
};

export default AdminUsersControls;