import React, { Component } from "react";
import { Link } from "react-router-dom"; // Import Link from react-router-dom
import UserService from "../services/user.service";

export default class CustomersListBoard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
      error: "",
    };
  }

  async componentDidMount() {
    try {
      const response = await UserService.getAllCustomersMethod();
      this.setState({ customers: response.data });
    } catch (error) {
      this.setState({
        error:
          (error.response && error.response.data && error.response.data.message) ||
          error.message ||
          error.toString(),
      });
    }
  }

  handleDeleteClick = async (id) => {
    try {
      await UserService.deleteCustomerMethod(id);
      this.setState({
        customers: this.state.customers.filter((c) => c.id !== id),
      });
    } catch (error) {
      this.setState({
        error:
          (error.response && error.response.data && error.response.data.message) ||
          error.message ||
          error.toString(),
      });
    }
  };

  render() {
    const { customers, error } = this.state;

    if (error) {
      return <div>{error}</div>;
    }

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>Customers List</h3>
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
                  <Link
                    to={`/Control-panel/edit/${customer.id}`} // Use Link to handle routing
                    className="btn btn-primary mr-2"
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      this.handleDeleteClick(customer.id);
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
  }
}