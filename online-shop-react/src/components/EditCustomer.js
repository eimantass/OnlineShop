import React, { Component } from "react";
import { withRouter } from 'react-router-dom';
import UserService from "../services/user.service";

class EditCustomer extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: null,
      username: "",
      email: "",
      password: "",
      number: "",
      money: "",
      roles: [],
      successful: false,
      message: ""
    };
  }

  componentDidMount() {
    const { id } = this.props.match.params;

    UserService.getCustomerById(id).then((response) => {
      const { id, username, email, password, number, money, roles } =
        response.data;
      this.setState({
        id: id,
        username: username,
        email: email,
        password: password,
        number: number,
        money: money,
        roles: roles
      });
    });
  }

  handleInputChange = (event) => {
    const { name, value } = event.target;
    this.setState({
      [name]: value
    });
  };

  handleFormSubmit = (event) => {
    event.preventDefault();

    this.setState({
      message: "",
      successful: false
    });

    const { id, username, email, password, number, money, roles } = this.state;

    UserService.updateCustomer(id, {
      username: username,
      email: email,
      password: password,
      number: number,
      money: money,
      roles: roles
    })
      .then((response) => {
        this.setState({
          message: response.data.message,
          successful: true
        });
      })
      .catch((error) => {
        const message =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        this.setState({
          successful: false,
          message: message
        });
      });
  };

  render() {
    const {
      id,
      username,
      email,
      password,
      number,
      money,
      roles,
      successful,
      message
    } = this.state;

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>Edit Customer</h3>
        </header>
        {message && (
          <div
            className={
              successful
                ? "alert alert-success"
                : "alert alert-danger"
            }
            role="alert"
          >
            {message}
          </div>
        )}
        <form onSubmit={this.handleFormSubmit}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input
              type="text"
              className="form-control"
              id="username"
              name="username"
              value={username}
              onChange={this.handleInputChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              className="form-control"
              id="email"
              name="email"
              value={email}
              onChange={this.handleInputChange}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              value={password}
              onChange={this.handleInputChange}
            />
          </div>

          <div className="form-group">
        <label htmlFor="number">Number</label>
        <input
          type="text"
          className="form-control"
          id="number"
          name="number"
          value={number}
          onChange={this.handleInputChange}
        />
      </div>

      <div className="form-group">
        <label htmlFor="money">Money</label>
        <input
          type="number"
          className="form-control"
          id="money"
          name="money"
          value={money}
          onChange={this.handleInputChange}
        />
      </div>

      <div className="form-group">
        <label htmlFor="roles">Roles</label>
        <input
          type="text"
          className="form-control"
          id="roles"
          name="roles"
          value={roles}
          onChange={this.handleInputChange}
        />
      </div>

      <button className="btn btn-primary">Save Changes</button>
    </form>
  </div>
);
        }
    }
    export default withRouter(EditCustomer);