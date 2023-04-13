import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import CartService from "../services/cart.service"; // Import CartService

function ProductList() {
  const [products, setProducts] = useState([]);
  const [selectedQuantity, setSelectedQuantity] = useState(1); // Add state for selected quantity
  const navigate = useNavigate();

  // Fetch the all products data from repository
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await ProductService.getAllProducts();
        setProducts(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  // Add product function
  const handleAddProduct = () => {
    navigate('/add-product');
  };

  // Edit Product function
  const handleEditProduct = async (id) => {
    navigate(`/update-product/${id}`);
  };

  // Remove Product function 
  const handleRemoveProduct = async (id) => {
    try {
      await ProductService.deleteProduct(id);
      setProducts(products.filter((product) => product.id !== id));
    } catch (error) {
      console.log(error);
    }
  };

  // Add to Cart function
  const handleAddToCart = async (id) => {
    try {
      await CartService.addProductToCart(id, selectedQuantity); // Pass the selected quantity along with the product ID
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <main>
    <h2 className="text-center">Products List:</h2>
  
    {/* The add product button   */}
    <button className="btn btn-primary" onClick={handleAddProduct}>
      Add Product
    </button>
    {/* Products List from Repository */}
    <ul className="list-unstyled row">
      {products.map((product) => (
        <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
          <div className="product-image-container">
            <img src={product.photo} alt={product.name} className="product-image img-fluid" />
          </div>
          <h3 className="product-name">{product.name}</h3>
          <p>Description: {product.description}</p>
          <p>Category: {product.category}</p>
          {/* Display brands */}
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
  
          {/* Below each product a remove button that removes the product */}
          <button className="btn btn-danger" onClick={() => handleRemoveProduct(product.id)}>
            Remove
          </button>
          {/* Below each product an edit button that navigates to the edit product page */}
          <button className="btn btn-secondary" onClick={() => handleEditProduct(product.id)}>
            Edit
          </button>
          {/* Select quantity */}
          {/* Input for quantity */}
          {/* Label for quantity */}
          <label>
            Quantity:
            <input
              type="number"
              value={product.quantity}
              onChange={(e) => {
                const newQuantity = parseInt(e.target.value);
                setProducts((prevProducts) =>
                  prevProducts.map((prevProduct) =>
                    prevProduct.id === product.id
                      ? { ...prevProduct, quantity: newQuantity }
                      : prevProduct
                  )
                );
              }}
              min={0}
              max={10}
              className="form-control"
            />
          </label>
          {/* Below each product an add to cart button */}
          <button
            className="btn btn-success"
            onClick={() => handleAddToCart(product.id, product.quantity)}
          >
            Add to Cart
          </button>
        </li>
      ))}
    </ul>
  </main>
  );
}

export default ProductList;