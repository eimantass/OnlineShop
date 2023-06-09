import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Profile from "./components/profile.component";
import BoardAdmin from "./components/board-admin.component";
import Cart from "./pages/Cart";
// import footerMenu pages
import About from "./pages/About";
import Contacts from "./pages/Contacts";
import Terms from "./pages/Terms";
import Shipping from "./pages/Shipping";
import Returns from "./pages/Returns";
import Warranty from "./pages/Warranty";
import Privacy from "./pages/Privacy";
import Feedback from "./pages/Feedback";
import Help from "./pages/Help";
// import categoriesMenu pages
import StaliniaiKompiuteriai from "./pages/categoriesMenuPages/staliniai-kompiuteriai";
import NesiojamiejiKompiuteriai from "./pages/categoriesMenuPages/nesiojamieji-kompiuteriai";
import KompiuteriuKomponentai from "./pages/categoriesMenuPages/kompiuteriu-komponentai";
import Monitoriai from "./pages/categoriesMenuPages/monitoriai";
import Mobilieji from "./pages/categoriesMenuPages/mobilieji";
import Plansetiniai from "./pages/categoriesMenuPages/plansetiniai";
import Spausdintuvai from "./pages/categoriesMenuPages/spausdintuvai";
import Konsoles from "./pages/categoriesMenuPages/konsoles";
import Zaidimai from "./pages/categoriesMenuPages/zaidimai";

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

              <li className="nav-item">
                <Link to={"/cart"} className="nav-link">
                  Cart
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
            <Route path="/admin" element={<BoardAdmin />} />
            <Route path="/cart" element={<Cart />} />
            {/*Footer menu paths below: */}
            <Route path="/about" element={<About />} />
            <Route path="/contacts" element={<Contacts />} />
            <Route path="/terms" element={<Terms />} />
            <Route path="/shipping" element={<Shipping />} />
            <Route path="/returns" element={<Returns/>} />
            <Route path="/warranty" element={<Warranty/>} />
            <Route path="/privacy" element={<Privacy/>} />
            <Route path="/feedback" element={<Feedback/>} />
            <Route path="/help" element={<Help/>} />
            {/*Categories menu paths below: */}
            <Route path="/staliniai-kompiuteriai" element={<StaliniaiKompiuteriai/>} />
            <Route path="/nesiojamieji-kompiuteriai" element={<NesiojamiejiKompiuteriai/>} />
            <Route path="/kompiuteriu-komponentai" element={<KompiuteriuKomponentai/>} />
            <Route path="/monitoriai" element={<Monitoriai/>} />
            <Route path="/mobilieji-telefonai" element={<Mobilieji/>} />
            <Route path="/plansetiniai-kompiuteriai" element={<Plansetiniai/>} />
            <Route path="/spausdintuvai" element={<Spausdintuvai/>} />
            <Route path="/zaidimu-konsoles" element={<Konsoles/>} />
            <Route path="/zaidimai" element={<Zaidimai/>} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;
