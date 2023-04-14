import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import UserService from "../services/user.service";

const CustomersList = () => {
  const [customers, setCustomers] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        const response = await UserService.getAllCustomersMethod();
        setCustomers(response.data);
      } catch (error) {
        setError(
          (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString()
        );
      }
    };
    fetchCustomers();
  }, []);

  const handleDeleteClick = async (id) => {
    try {
      await UserService.deleteCustomerMethod(id);
      setCustomers(customers.filter((c) => c.id !== id));
    } catch (error) {
      setError(
        (error.response && error.response.data && error.response.data.message) ||
          error.message ||
          error.toString()
      );
    }
  };

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div className="container">
      <header className="jumbotron">
        <h2>Users List and Controls</h2>
      </header>
      <table className="table">
        <thead>
          <tr>
            <th>Email</th>
            <th>Username</th>
            <th>Number</th>
            <th>Money</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.id}>
              <td>{customer.email}</td>
              <td>{customer.username}</td>
              <td>{customer.number}</td>
              <td>{customer.money}</td>
              <td>
                <Link to={`/Control-panel/edit/${customer.id}`} className="btn btn-primary mr-2">
                  Edit
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => {
                    handleDeleteClick(customer.id);
                  }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CustomersList;