import React, { Component } from "react";
import Categories from "./categories-menu";
import ProductList from "./ProductList";

export default class Home extends Component {
  render() {
    return (
      <div>
        <Categories/>
        <ProductList/>
      </div>
    );
  }
}