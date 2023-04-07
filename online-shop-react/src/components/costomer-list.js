import React, { useEffect, useState } from "react";
import UserService from "../services/user.service";

const CustomersListBoard2 = ({ history }) => {
  const [customers, setCustomers] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    UserService.getAllCustomersMethod()
      .then((response) => {
        setCustomers(response.data);
      })
      .catch((error) => {
        setError(
          (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString()
        );
      });
  }, []);

  const handleEditClick = (id) => {
    navigate("/edit-customer/" + id);
  };

  const handleDeleteClick = (id) => {
    UserService.deleteCustomerMethod(id)
      .then(() => {
        setCustomers(customers.filter((c) => c.id !== id));
      })
      .catch((error) => {
        setError(
          (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString()
        );
      });
  };

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>Customers List</h3>
      </header>
      {error ? (
        <div>{error}</div>
      ) : (
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
                  <button
                    className="btn btn-primary mr-2"
                    onClick={() => handleEditClick(customer.id)}
                  >
                    Edit
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => handleDeleteClick(customer.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default CustomersListBoard2;