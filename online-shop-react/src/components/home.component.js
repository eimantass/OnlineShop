import React, { Component } from "react";
import Categories from "./categories-menu";
import ProductList from "./ProductList";
import SeachAndLogo from "../layout/searchandlogo";

export default class Home extends Component {
  render() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <ProductList/>
      </div>
    );
  }
}