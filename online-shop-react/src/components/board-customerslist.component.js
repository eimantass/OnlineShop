import React, { Component } from "react";
import UserService from "../services/user.service";

export default class CustomersListBoard extends Component {
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
                    onClick={() => {
                      this.props.history.push("/edit-customer/" + customer.id);
                    }}
                  >
                    Edit
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      UserService.deleteCustomerMethod(customer.id).then(() => {
                        this.setState({
                          customers: this.state.customers.filter(
                            (c) => c.id !== customer.id
                          ),
                        });
                      });
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