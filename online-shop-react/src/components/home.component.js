import React, { Component } from "react";

import UserService from "../services/user.service";
import Categories from "./categories-menu";

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      content: ""
    };
  }

  componentDidMount() {
    UserService.getPublicContent().then(
      response => {
        this.setState({
          content: response.data
        });
      },
      error => {
        this.setState({
          content:
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        });
      }
    );
  }

  render() {
    return (
      <div>
      <Categories/>
  
        <main>
          <h2 class="center">Test Text1</h2>
  
          <h1 class="center">Text2</h1>
  
          <h1 class="center">Text3</h1>
  
          <h1 class="center">Text4</h1>
  
          <h1>Text5</h1>
  
          <h1>Text6</h1>
  
          <h1>Text7</h1>
  
          <h1>Text8</h1>
  
          <h1>Text9</h1>
  
          <h1>Text10</h1>
        </main>
      </div>
    );
  }
}