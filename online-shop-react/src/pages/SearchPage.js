import React, { Component } from "react";
import SearchpageT from "../layout/searchpage";
import Categories from "../components/categories-menu";
import SeachAndLogo from "../layout/searchandlogo";

import "../App.css";

export default class TSearchPage extends Component {
  render(){
  return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <SearchpageT/>
      </div>
    );
  }
}