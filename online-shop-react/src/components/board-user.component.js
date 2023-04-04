import React, { Component } from "react";
import UserService from "../services/user.service";

export default class BoardUser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      users: []
    };
  }

  componentDidMount() {
    UserService.getAllUsers().then(
      response => {
        this.setState({
          users: response.data
        });
      },
      error => {
        this.setState({
          content:
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString()
        });
      }
    );
  }

  render() {
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>Users:</h3>
          <ul>
            {this.state.users.map(user => (
              <li key={user.id}>{user.username}</li>
            ))}
          </ul>
        </header>
      </div>
    );
  }
}