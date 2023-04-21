import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import './css/product-list.css';

function AdminProductList() {
  const [products, setProducts] = useState([]);
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

  return (
    <main>
        <div className="container">
    <h2 className="text-center">Products List</h2>
    <table className="table table-striped">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Brand</th>
          <th>Price</th>
          <th style={{ textAlign: 'center' }}>Quantity in Stock</th>
          <th>Description</th>
          {/* <th>Parameters</th> */}
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {products.map((product) => (
          <tr key={product.id}>
            <td>{product.id}</td>
            <td>{product.name}</td>
            <td>{product.brand}</td>
            <td>{product.price}</td>
            <td style={{ textAlign: 'center' }}>{product.quantity}</td>
            <td>{product.description}</td>
            {/* <td>
              {product.productParameters.map((parameter) => (
                <p key={parameter.id}>
                  {parameter.name}: {parameter.description}
                </p>
              ))}
            </td> */}
            <td>
              <button
                className="btn btn-primary mr-2"
                onClick={() => handleEditProduct(product.id)}
              >
                Edit
              </button>
              <button
                className="btn btn-danger"
                onClick={() => handleRemoveProduct(product.id)}
              >
                Remove
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
  </main>
  );
}

export default AdminProductList;