import React, { useEffect, useState } from "react";
import ProductService from "../services/product.service";

function ProductList() {
  const [products, setProducts] = useState([]);

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

  const handleAddProduct = async () => {
    try {
      const newProduct = { name: "New Product", price: 0 };
      const response = await ProductService.createProduct(newProduct);
      setProducts([...products, response.data]);
    } catch (error) {
      console.log(error);
    }
  };

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
      <button onClick={handleAddProduct}>Add Product</button>
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
            <button onClick={() => handleRemoveProduct(product.id)}>
              Remove
            </button>
          </li>
        ))}
      </ul>
    </main>
  );
}

export default ProductList;




