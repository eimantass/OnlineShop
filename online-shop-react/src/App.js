import React, { Component } from "react";
import { Route, Link, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Profile from "./components/profile.component";
import CustomersListBoard from "./components/board-customerslist.component";
import CustomerBoard from "./components/board-customer.component";
import ManagerBoard from "./components/board-manager.component";
import AdminBoard from "./components/board-admin.component";
// Import function pages
import AdminProductControls from "./components/AdminProductControls";
import AddProductForm from "./components/add-product"
import UpdateProduct from "./components/update-product"
// Import CategoriesMenu pages
import Processors from "./pages/categoriesMenuPages/processors";
import Laptops from "./pages/categoriesMenuPages/laptops";
import GraphicsCards from "./pages/categoriesMenuPages/graphicsCards";
import Mainboards from "./pages/categoriesMenuPages/mainboards";
import MobilePhones from "./pages/categoriesMenuPages/mobile-phones";
import Monitors from "./pages/categoriesMenuPages/monitors";
import Printers from "./pages/categoriesMenuPages/printers";
import Consoles from "./pages/categoriesMenuPages/consoles";
import Games from "./pages/categoriesMenuPages/games";
// Import FooterMenu pages
import About from "./pages/About";
import Contacts from "./pages/Contacts";
import Terms from "./pages/Terms";
import Shipping from "./pages/Shipping";
import Returns from "./pages/Returns";
import Warranty from "./pages/Warranty";
import Privacy from "./pages/Privacy";
import Feedback from "./pages/Feedback";
import Help from "./pages/Help";
// Admin Control Panel
import AdminControlPanel from "./layout/AdminControlPanel";
import ShoppingCart from "./pages/shoppingCart";

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
        showManagerBoard: user.roles.includes("MANAGER", "SERVICEMANAGER"),
        showAdminBoard: user.roles.includes("ADMIN"),
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
    const { currentUser, showManagerBoard, showAdminBoard } = this.state;

    return (
      <>
      
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
                CUSTOMER BOARD
                </Link>
              </li>
              
            )}
           {/* Unneeded Top Menu function */}
            {/* {currentUser && (
              <li className="nav-item">
                <Link to={"/customers"} className="nav-link">
                CUSTOMERS LIST
                </Link>
              </li>
            )} */}
            {currentUser && (
              <li className="nav-item">
                <Link to={"/cart"} className="nav-link">
                Product Cart
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
    <Route exact path="/" element={<Home />} />
    <Route path="/home" element={<Home />} />
    <Route path="/login" element={<Login/>} />
    <Route path="/register" element={<Register/>} />
    <Route path="/profile" element={<Profile/>} />
    <Route path="/customers" element={<CustomersListBoard/>} />
    <Route path="/customer" element={<CustomerBoard/>} />
    <Route path="/manager" element={<ManagerBoard/>} />
    <Route path="/admin" element={<AdminBoard/>} />
    <Route path="/admin-user-control/edit/:id" element={<AdminControlPanel/>}/> 
    {/* Cart */}
    <Route path="/cart" element={<ShoppingCart/>} />
    {/* Products */}
    <Route path="/products" element={<AdminProductControls/>} />
    <Route path="/add-product" element={<AddProductForm/>} />
    <Route path="/update-product/:id" element={<UpdateProduct/>} />
    {/* Routes to CategoriesMenu pages */}
    <Route path="/processors" element={<Processors/>} />
    <Route path="/laptops" element={<Laptops/>} />
    <Route path="/graphics-cards" element={<GraphicsCards/>} />
    <Route path="/mainboards" element={<Mainboards/>} />
    <Route path="/mobile-phones" element={<MobilePhones/>} />
    <Route path="/monitors" element={<Monitors/>} />
    <Route path="/printers" element={<Printers/>} />
    <Route path="/consoles" element={<Consoles/>} />
    <Route path="/games" element={<Games/>} />
    {/* Routes to footerMenu pages */}
    <Route path="/about" element={<About/>} />
    <Route path="/contacts" element={<Contacts/>} />
    <Route path="/terms" element={<Terms/>} />
    <Route path="/shipping" element={<Shipping/>} />
    <Route path="/returns" element={<Returns/>} />
    <Route path="/warranty" element={<Warranty/>} />
    <Route path="/privacy" element={<Privacy/>} />
    <Route path="/feedback" element={<Feedback/>} />
    <Route path="/help" element={<Help/>} />
    </Routes>
        </div>
      </div>
      </>
    );
  }
}

export default App;
