import React, { Component } from "react";
import ProductService from "../services/product.service";

class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
      cart: []
    };
    this.handleAddToCart = this.handleAddToCart.bind(this);
    this.handleRemoveFromCart = this.handleRemoveFromCart.bind(this);
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

  handleAddToCart(product) {
    const { cart } = this.state;
    const existingItem = cart.find(item => item.product.id === product.id);
    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      cart.push({ product: product, quantity: 1 });
    }
    this.setState({ cart: cart });
  }

  handleRemoveFromCart(product) {
    const { cart } = this.state;
    const existingItem = cart.find(item => item.product.id === product.id);
    if (existingItem.quantity > 1) {
      existingItem.quantity -= 1;
    } else {
      const itemIndex = cart.findIndex(item => item.product.id === product.id);
      cart.splice(itemIndex, 1);
    }
    this.setState({ cart: cart });
  }

  render() {
    const { products, cart } = this.state;
    return (
      <main>
        <h2 className="center">Products List:</h2>
        <ul>
          {products.map(product => (
            <li key={product.id}>
              <h3>{product.name}</h3>
              <p>{product.description}</p>
              <p>Category: {product.category}</p>
              <p>Price: ${product.price}</p>
              <button onClick={() => this.handleAddToCart(product)}>Add to Cart</button>
              <button onClick={() => this.handleRemoveFromCart(product)}>Remove from Cart</button>
            </li>
          ))}
        </ul>
      </main>
    );
  }
}

export default ProductList;