import './css/AdminEditPage.css';
import {useParams} from 'react-router-dom';
import React, { useState, useEffect,} from 'react';
import './css/Customers.css';
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";



const SearchpageT = () => {

  //console.log(useParams());
  const {val} = useParams();
  const [products, setProducts] = useState([]);
  const [productsNEW, setProductsNEW] = useState([]);
  const navigate = useNavigate();

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
    //FilterItem();
  }, []);

  const handleAddProduct = () => {
    navigate('/add-product');
  };

  const handleEditProduct = async (id) => {
    navigate(`/update-product/${id}`);
  };

  const handleRemoveProduct = async (id) => {
    try {
      await ProductService.deleteProduct(id);
      setProducts(products.filter((product) => product.id !== id));
    } catch (error) {
      console.log(error);
    }
  };

  //function Thingy() {
    //useEffect(() => {
    //  filterItem();
    //}, []);
    
  const FilterItem = () => {
    const query = val;
    console.log(query, "= Variable");

    const updatedList = products.filter(products => products.name.includes(query)
    || products.description.includes(query)
    || products.category.includes(query)
    || products.brand.includes(query));

    console.log("updateList worked");         

    setProductsNEW(updatedList);
  console.log("set new product")
  };
  //}

  return (
<main>
      <h2> </h2>
      <h2 className="center">Products List containing {val}:</h2>
      {/* The add product button   */}
      <button onClick={handleAddProduct}>Add Product</button>
      {/* Products List from Repository */}
      <FilterItem/>

      <ul>
        {productsNEW.map((product) => (
          <li key={product.id}>
            <h3>{product.name}</h3>
            <img src={product.photo} alt={product.name} />
            <p>Description: {product.description}</p>
            <p>Category: {product.category}</p>
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
            <button onClick={() => handleRemoveProduct(product.id)}>
              Remove
            </button>
            <button onClick={() => handleEditProduct(product.id)}>
              Edit
            </button>
          </li>
        ))}
      </ul>
    </main>
  );
};

export default SearchpageT;