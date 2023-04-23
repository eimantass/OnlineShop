import React, { useState, useEffect } from "react";
import SortService from "../services/sort.service";
// import CartService from "../services/cart.service";
import {useTranslation} from 'react-i18next';

const ConsolesProductList = () => {
  const [products, setProducts] = useState([]);
  // const [selectedQuantity, setSelectedQuantity] = useState(1); // Add state for selected quantity

  useEffect(() => {
    SortService.sortByConsoles("GAMECONSOLES")  // Call the sort service to retrieve products by category
      .then(products => {
        setProducts(products); // Update the state with retrieved products
      })
      .catch(error => {
        console.error("Failed to retrieve products:", error);
      });
  }, []);

    // Add to Cart function
    // const handleAddToCart = async (id) => {
    //   try {
    //     await CartService.addProductToCart(id, selectedQuantity); // Pass the selected quantity along with the product ID
    //   } catch (error) {
    //     console.log(error);
    //   }
    // };

    const { t } = useTranslation();
  return (
<div className="container">
  <h1 className="text-center"> {t('consolesList')}</h1>
  <ul className="list-unstyled row">
    {products.map((product) => (
      <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
        <div className="product-image-container">
          <img src={product.photo} alt={product.name} className="product-image img-fluid" />
        </div>
        <h3 className="product-name">{product.name}</h3>
        <p><b>{t('description')}</b> {product.description}</p>
        <p><b>{t('category')}</b> {product.category}</p>
        <p><b>{t('brand')}</b> {product.brand}</p>
        <p><b>{t('price')}</b> {product.price.toLocaleString('de-DE', {style: 'currency', currency: 'EUR'})}</p>
        <p><b>{t('quantitystock')}</b>{product.quantity}</p>
        {/* <button
          className="btn btn-success"
          onClick={() => handleAddToCart(product.id, product.quantity)}
        >
         {t('addtocart')}
        </button> */}
      </li>
    ))}
  </ul>
</div>
    
  );
};

export default ConsolesProductList;