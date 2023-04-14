import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import UserService from "../services/user.service";
import AuthService from "../services/auth.service";

const CustomerBoard = () => {
  const [content, setContent] = useState("");
  const [customerData, setCustomerData] = useState(null);

  useEffect(() => {
    const currentUser = AuthService.getCurrentUser();
    if (currentUser) {
      // Fetch customer data using the current user ID
      UserService.getCustomerByIdMethod(currentUser.id)
        .then((response) => {
          setCustomerData(response.data);
        })
        .catch((error) => {
          setContent(
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
              error.message ||
              error.toString()
          );
        });
    } else {
      // Handle case when no current user is available
      setContent("No current user found.");
    }
  }, []);

  if (customerData) {
    // Render customer data in a table
    return (
        <div className="container">
            <h2>Customer Board</h2>
        {customerData ? (
          <table className="table">
            <thead>
              <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Number</th>
                <th>Money</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{customerData.username}</td>
                <td>{customerData.email}</td>
                <td>{customerData.number}</td>
                <td>{customerData.money}</td>
                <td>
                <Link to={`/Control-panel/edit/${customerData.id}`} className="btn btn-primary mr-2">
                  Edit User Information
                </Link>
              </td>
              </tr>
            </tbody>
          </table>
        ) : (
          <header className="jumbotron">
            <h3>Loading user data...</h3>
          </header>
        )}
      </div>
    );
  } else {
    // Render loading or error message
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>{content}</h3>
        </header>
      </div>
    );
  }
};

export default CustomerBoard;