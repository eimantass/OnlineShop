import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";

function ProductList() {
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

  return (
    <main>
      <h2 className="center">Products List:</h2>

      {/* The add product button   */}
      <button onClick={handleAddProduct}>Add Product</button>
      {/* Products List from Repository */}
      <ul>
        {products.map((product) => (
          <li key={product.id}>
            <h3>{product.name}</h3>
            <img src={product.photo} alt={product.name} />
            <p>{product.description}</p>
            <p>Category: {product.category.name}</p>
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
            <button onClick={() => handleRemoveProduct(product.id)}>
              Remove
            </button>
            {/* Below each product an edit button that navigates to the edit product page */}
            <button onClick={() => handleEditProduct(product.id)}>
              Edit
            </button>
          </li>
        ))}
      </ul>
    </main>
  );
}

export default ProductList;