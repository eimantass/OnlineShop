import React, { Component } from "react";
import UserService from "../services/user.service";

export default class CustomerBoard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customers: [],
      error: "",
    };
  }

  componentDidMount() {
    UserService.getAllCustomersMethod()
      .then((response) => {
        this.setState({ customers: response.data });
      })
      .catch((error) => {
        this.setState({
          error:
            (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString(),
        });
      });
  }

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
            </tr>
          </thead>
          <tbody>
            {customers.map((customer) => (
              <tr key={customer.id}>
                <td>{customer.email}</td>
                <td>{customer.username}</td>
                <td>{customer.number}</td>
                <td>{customer.money}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}