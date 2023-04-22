import React, { Component } from "react";
import { Route, Link, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";
import LanguageSwitcher from "./components/LanguageSwitcher";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Profile from "./components/profile.component";
import CustomerBoard from "./components/board-customer.component";
import ManagerBoard from "./components/board-manager.component";
import ServiceManagerBoard from "./components/board-servicemanager.component";
import ServiceManagerCustomers from "./components/ServiceManager-Customers";
import AdminBoard from "./components/board-admin.component";
// Import function pages
import AdminProductControls from "./components/AdminProductControls";
import AdminUsersControls from "./components/AdminUsersControls";
import AdminAdminsControls from "./components/AdminAdminsControls";
import AdminServiceManagersControls from "./components/AdminServiceManagersControls";
import AdminManagersControls from "./components/AdminManagersControls";
import AdminCustomersControls from "./components/AdminCustomersControls";
import AdminCartsControls from "./components/AdminCartsControls";
import ManagerProductControls from "./components/ManagerProductControls";
import AddProductForm from "./components/add-product"
import UpdateProduct from "./components/update-product"
import OrderList from "./components/OrderList";
import UserOrder from "./components/UserOrder";
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
//import TestPage from "./layout/AdminEditPage";
//import AdminControllMenuAAM from "./components/AdminControllMenuP";
import TSearchPage from "./pages/SearchPage";

import AdminControlPanel from "./layout/AdminControlPanel";
import ServiceManagerControlPanel from "./layout/ServiceManagerControlPanel";
import UserControlPanel from "./layout/UserControlPanel";
import ShoppingCart from "./pages/shoppingCart";
import WishList from "./components/WishList";

import { withTranslation } from 'react-i18next';


class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showManagerBoard: false,
      showServiceManagerBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
      language: 'en',
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showManagerBoard: user.roles.includes("MANAGER"),
        showServiceManagerBoard:  user.roles.includes("SERVICEMANAGER"),
        showAdminBoard: user.roles.includes("ADMIN"),
      });
    }
  }

  logOut() {
    AuthService.logout();
    this.setState({
      showManagerBoard: false,
      showServiceManagerBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { t } = this.props;
    const { currentUser, showManagerBoard, showServiceManagerBoard, showAdminBoard} = this.state;
  
    return (
      <>
      <div>

        <nav className="navbar navbar-expand navbar-dark bg-dark">

        <Link to={"/"} className="navbar-brand">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM5GgYJWQI9E0nPyj1XpO3VfQdkBEyCia-2g&usqp=CAU" alt="WebPage" style={{ width: "60px", height: "60px" }}/>
        </Link>

          <div className="navbar-nav mr-auto">

            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
              {t('home')}
              </Link>
            </li>

            {showManagerBoard && (
              <li className="nav-item">
                <Link to={"/manager"} className="nav-link">
                {t('managerB')}
                </Link>
              </li>
            )}

              {showServiceManagerBoard && (
              <li className="nav-item">
                <Link to={"/servicemanager"} className="nav-link">
                {t('servicemanagerB')}
                </Link>
              </li>
            )}

            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                {t('adminb')}
                </Link>
              </li>
            )}

{/* Moved customerboard to Profile functions */}

            {/* {currentUser && (
              <li className="nav-item">
                <Link to={"/customer"} className="nav-link">
                {t('customerB')}
                </Link>
              </li>
              
            )} */}
              {currentUser && (
              <li className="nav-item ml-auto">
                <Link to={"/cart"} className="nav-link">
                <img src="https://cdn.iconscout.com/icon/free/png-512/shopping-cart-452-1163339.png" alt="Cart" style={{ width: "30px", height: "30px", filter: "invert(23%) sepia(100%) saturate(7457%) hue-rotate(357deg) brightness(111%) contrast(116%)" }} />
                  {t('productC')}
                </Link>
              </li>
              )}
        
        {currentUser && (
  <li className="nav-item">
    <Link to={"/wishlist"} className="nav-link">
      <img src="https://cdn.iconscout.com/icon/free/png-512/heart-1767836-1502416.png" alt="Wishlist" style={{ width: "30px", height: "30px", filter: "invert(23%) sepia(100%) saturate(7457%) hue-rotate(357deg) brightness(111%) contrast(116%)" }} />
      {t('wish')}
    </Link>
  </li>
)}
          </div>

          {/* Current user can see these menus */}
          {currentUser ? (
            <div className="navbar-nav ml-auto">

              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>

              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                {t('logout')}
                </a>
              </li>

              {/* Changed from button to a Link tag for LanguageSwitcher component */}
              <LanguageSwitcher />

            </div>

          ) : (

            // Only guest can see
            <div className="navbar-nav ml-auto">

              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                {t('login')}
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                {t('signup')}
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
    <Route path="/customer" element={<CustomerBoard/>} />
    <Route path="/manager" element={<ManagerBoard/>} />
    <Route path="/servicemanager" element={<ServiceManagerBoard/>} />
    <Route path="/servicemanager-customers" element={<ServiceManagerCustomers/>} />
    <Route path="/manager-user-control/edit/:id" element={<ServiceManagerControlPanel/>} />
    <Route path="/admin" element={<AdminBoard/>} />
    <Route path="/user-control/edit/:id" element={<UserControlPanel/>}/> 
    <Route path="/user-order/:id" element={<UserOrder/>}/> 
    <Route path="/admin-user-control/edit/:id" element={<AdminControlPanel/>}/> 
    {/* Cart */}
    <Route path="/cart" element={<ShoppingCart/>} />
    {/* Wish-list */}
    <Route path="/wishlist" element={<WishList/>} />
    {/* Products */}
    <Route path="/products" element={<AdminProductControls/>} />
    <Route path="/users" element={<AdminUsersControls/>} />
    <Route path="/admins" element={<AdminAdminsControls/>} />
    <Route path="/servicemanagers" element={<AdminServiceManagersControls/>} />
    <Route path="/managers" element={<AdminManagersControls/>} />
    <Route path="/customers" element={<AdminCustomersControls/>} />
    <Route path="/carts" element={<AdminCartsControls/>} />
    <Route path="/orders" element={<OrderList/>} />
    <Route path="/manager-products" element={<ManagerProductControls/>} />
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
    <Route path="/search/:val" element={<TSearchPage/>}/>

    </Routes>
        </div>
      </div>
      </>
    );
  }
}

export default withTranslation()(App);
