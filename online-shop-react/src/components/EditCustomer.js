import React, { Component } from "react";
import { useNavigate } from 'react-router-dom';
import UserService from "../services/user.service";

export default function EditCustomer(props) {
  const navigate = useNavigate();

  const [state, setState] = React.useState({
    id: null,
    username: "",
    email: "",
    password: "",
    number: "",
    money: "",
    roles: [],
    successful: false,
    message: ""
  });

  const { id } = props.match.params;

  React.useEffect(() => {
    UserService.getCustomerById(id).then((response) => {
      const { id, username, email, password, number, money, roles } = response.data;
      setState({
        id: id,
        username: username,
        email: email,
        password: password,
        number: number,
        money: money,
        roles: roles
      });
    });
  }, [id]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setState(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();

    setState(prevState => ({
      ...prevState,
      message: "",
      successful: false
    }));

    const { id, username, email, password, number, money, roles } = state;

    UserService.updateCustomer(id, {
      username: username,
      email: email,
      password: password,
      number: number,
      money: money,
      roles: roles
    })
      .then((response) => {
        setState(prevState => ({
          ...prevState,
          message: response.data.message,
          successful: true
        }));
        navigate(`/customer/${id}`);
      })
      .catch((error) => {
        const message =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        setState(prevState => ({
          ...prevState,
          successful: false,
          message: message
        }));
      });
  };

  const {
    username,
    email,
    password,
    number,
    money,
    roles,
    successful,
    message
  } = state;

  return (
    <div className="col-md-12">
      <div className="card card-container">
        <h3>Edit Customer</h3>
        <form onSubmit={handleFormSubmit}>
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input
              type="text"
              className="form-control"
              id="username"
              required
              value={username}
              onChange={handleInputChange}
              name="username"
            />
          </div>

          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              className="form-control"
              id="email"
              required
              value={email}
              onChange={handleInputChange}
              name="email"
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              required
              value={password}
              onChange={handleInputChange}
              name="password"
            />
          </div>

          <div className="form-group">
            <label htmlFor="number">Number</label>
            <input
              type="text"
              className="form-control"
              id="number"
              required
              value={number}
              onChange={handleInputChange}
              name="number"
            />
          </div>

          <div className="form-group">
            <label htmlFor="money">Money</label>
            <input
              type="text"
              className="form-control"
              id="money"
              required
              value={money}
              onChange={handleInputChange}
              name="money"
            />
          </div>

          <div className="form-group">
            <label htmlFor="roles">Roles</label>
            <input
              type="text"
              className="form-control"
              id="roles"
              required
              value={roles}
              onChange={handleInputChange}
              name="roles"
            />
          </div>

          <div className="form-group">
            <button className="btn btn-primary btn-block">Save Changes</button>
          </div>

          {message && (
            <div className="form-group">
              <div
                className={successful ? "alert alert-success" : "alert alert-danger"}
                role="alert"
              >
                {message}
              </div>
            </div>
          )}
        </form>
      </div>
    </div>
  );
}