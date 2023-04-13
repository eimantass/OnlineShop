import React, { useState, useEffect } from "react";
import SortService from "../services/sort.service";
;

const MobilePhonesProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    SortService.sortByMobilePhones("MOBILE_PHONES") // Call the sort service to retrieve products by category
      .then(products => {
        setProducts(products); // Update the state with retrieved products
      })
      .catch(error => {
        console.error("Failed to retrieve products:", error);
      });
  }, []);

  return (
<div className="container">
      <h1>Mobile Phones List</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Description</th>
            <th>Parameters</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>{product.brand}</td>
              <td>{product.price}</td>
              <td>{product.description}</td>
              <td>
                {product.productParameters.map((parameter) => (
                  <p key={parameter.id}>
                    {parameter.name}: {parameter.description}
                  </p>
                ))}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MobilePhonesProductList;