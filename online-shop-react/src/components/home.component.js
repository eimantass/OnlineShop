import React, { Component } from "react";
import ProductService from "../services/product.service";
import Categories from "./categories-menu";

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: []
    };
  }

  componentDidMount() {
    ProductService.getAllProducts().then(
      response => {
        this.setState({
          products: response.data
        });
      },
      error => {
        console.log(error);
      }
    );
  }

  render() {
    const { products } = this.state;
    return (
      <div>
        <Categories />
        <main>
          <h2 className="center">Products List:</h2>
          <ul>
            {products.map(product => (
              <li key={product.id}>
                <h3>{product.name}</h3>
                <p>{product.description}</p>
                <p>Category: {product.category}</p>
                <p>Price: ${product.price}</p>
              </li>
            ))}
          </ul>
        </main>
      </div>
    );
  }
}