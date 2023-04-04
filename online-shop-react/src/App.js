import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Profile from "./components/profile.component";
import BoardCustomer from "./components/board-customer.component";
import BoardManager from "./components/board-manager.component";
import BoardServiceManager from "./components/board-service-manager.component";

import BoardAdmin from "./components/board-admin.component";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showManagerBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showManagerBoard: user.roles.includes("ROLE_MANAGER"),

        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  logOut() {
    AuthService.logout();
    this.setState({
      showManagerBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { showServiceManagerBoard,currentUser, showManagerBoard, showAdminBoard,  } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            WebPage

          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
                Home
              </Link>
            </li>

            {showManagerBoard && (
              <li className="nav-item">
                <Link to={"/manager"} className="nav-link">
                  Manager Board
                </Link>
              </li>
            )}
     {showServiceManagerBoard && (
              <li className="nav-item">
                <Link to={"/service-manager"} className="nav-link">
                  Service Manager Board
                </Link>
              </li>
            )}
            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                  Admin Board
                </Link>
              </li>
            )}

            {currentUser && (
              <li className="nav-item">
                <Link to={"/customer"} className="nav-link">
                  Customer board
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/home" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/customer" element={<BoardCustomer />} />
            <Route path="/manager" element={<BoardManager />} />
            <Route path="/service-manager" element={<BoardServiceManager />} />
            <Route path="/admin" element={<BoardAdmin />} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;
