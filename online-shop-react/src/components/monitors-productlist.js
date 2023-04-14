import React, { useState, useEffect } from "react";
import SortService from "../services/sort.service";
import CartService from "../services/cart.service"; // Import CartService

const MonitorsProductList = () => {
  const [products, setProducts] = useState([]);
  const [selectedQuantity, setSelectedQuantity] = useState(1); // Add state for selected quantity

  useEffect(() => {
    SortService.sortByMonitors("MONITORS") // Call the sort service to retrieve products by category
      .then(products => {
        setProducts(products); // Update the state with retrieved products
      })
      .catch(error => {
        console.error("Failed to retrieve products:", error);
      });
  }, []);

// Add to Cart function
const handleAddToCart = async (id) => {
  try {
    await CartService.addProductToCart(id, selectedQuantity); // Pass the selected quantity along with the product ID
  } catch (error) {
    console.log(error);
  }
};

  return (
<div className="container">
  <h1 className="text-center">Monitors List</h1>
  <ul className="list-unstyled row">
    {products.map((product) => (
      <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
        <div className="product-image-container">
          <img src={product.photo} alt={product.name} className="product-image img-fluid" />
        </div>
        <h3 className="product-name">{product.name}</h3>
        <p>Description: {product.description}</p>
        <p>Brand: {product.brand}</p>
        <p>Price: ${product.price}</p>
        {product.productParameters.length > 0 && (
          <ul>
            {product.productParameters.map((parameter) => (
              <li key={parameter.id}>
                <p>
                  {parameter.name}: {parameter.description}
                </p>
              </li>
            ))}
          </ul>
        )}
        <button
          className="btn btn-success"
          onClick={() => handleAddToCart(product.id, product.quantity)}
        >
          Add to Cart
        </button>
      </li>
    ))}
  </ul>
</div>
  );
};

export default MonitorsProductList;