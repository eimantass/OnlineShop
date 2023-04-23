import './css/AdminEditPage.css';
import {useParams} from 'react-router-dom';
import React, { useState, useEffect,} from 'react';
import './css/Customers.css';
import { useNavigate } from "react-router-dom";
import ProductService from "../services/product.service";
import WishListService from "../services/wishlist.service";
import CartService from "../services/cart.service";
import {useTranslation} from 'react-i18next';



const SearchpageT = () => {
  const {val} = useParams();
  const [products, setProducts] = useState([]);
  const [productsNEW, setProductsNEW] = useState([]);
  const [currentUser, setCurrentUser] = useState(null);
  const navigate = useNavigate();
 
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await ProductService.getAllProducts();
        const productsWithQuantity = response.data.map(product => ({
          ...product,
          selectedQuantity: product.quantity > 0 ? 1 : 0
        }));
        setProducts(productsWithQuantity);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, []);

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem('user'));
    setCurrentUser(user);
  }, []);

  useEffect(() => {
    FilterItem();
  })

  const FilterItem = () => {
    const query = val;
    //console.log(query, "= Variable");

    const updatedList = products.filter(products => products.name.includes(query)
    || products.description.includes(query)
    || products.category.includes(query)
    || products.brand.includes(query));

    //console.log("updateList worked");    

    setProductsNEW(updatedList);
  //console.log("set new product")
  };

  const handleAddToWishlist = async (product) => {
    if (!currentUser) {
      // Redirect the user to the login page if not logged in
      navigate("/login");
      return;
    }

    try {
      // Get all wishlists of the user
      const wishlists = await WishListService.getAllWishListsByUserId(currentUser.id);
      // If user doesnt have a wishlist - create it
      if (!wishlists || wishlists.length === 0) {
        await WishListService.createWishListByUserId(currentUser.id);
      } 
      // Check again for wishlists as per userID
      let wishlists2 = await WishListService.getAllWishListsByUserId(currentUser.id);

      // Sort the wishlists by createdAt field in descending order
      wishlists2 = wishlists2.sort((a, b) => {
        if (a.createdAt > b.createdAt) return -1;
        if (a.createdAt < b.createdAt) return 1;
        return 0;
      });
      // We select the latest wishlist we get from wish list of the user and assign it
      let wishlist;
      wishlist = wishlists2[0];

      // Construct the data to be sent in the request body
      const data = {
        productId: product.id,
        cartId: wishlist.id
      };

      console.debug("Sending JSON Wishlist: ", data);

      await WishListService.addItemToWishList(wishlist.id, product.id);

      alert(`Product ${product.name} has been added to your Wish List.`);
    } catch (error) {
      console.log(error);
      alert("Failed to add the product to your Wish List.");
    }
  };

  const handleAddToCart = async (product) => {
    if (!currentUser) {
      navigate("/login");
      return;
    }
  
    const confirmed = window.confirm(`Are you sure you want to add ${product.name} to your cart?`);
  
    if (!confirmed) {
      return;
    }
  
    try {
      const currentUser = JSON.parse(localStorage.getItem('user'));
      const carts = await CartService.GetActiveCarts(currentUser.id);
  
      let cart;
      
      if (!carts || carts.length === 0) {
        cart = await CartService.createCartByUserId(currentUser.id);
        
      } else {
        carts.sort((a, b) => b.createdAt - a.createdAt);
        cart = carts[0];
      }
  
      await CartService.addItemToCart(cart.id, product.id, product.selectedQuantity);
  
      alert(`Product ${product.name} has been added to your cart.`);
      console.debug("Sending JSON Cart: ", cart.id, product.id, product.selectedQuantity);
  
      
    } catch (error) {
      console.log(error);
    }
  };

  const handleQuantityChange = (product, newQuantity) => {
    setProducts((prevProducts) =>
      prevProducts.map((prevProduct) =>
        prevProduct.id === product.id
          ? {
              ...prevProduct,
              selectedQuantity: newQuantity > prevProduct.quantity ? prevProduct.quantity : newQuantity,
            }
          : prevProduct
      )
    );
  };

  const { t } = useTranslation();
  return (
    <main>
      <h2 className="text-center">{t('Filt')+val}</h2>
      <ul className="list-unstyled row">
        {productsNEW.map((product) => (
          <li key={product.id} className="product-item col-md-6 col-lg-4 col-xl-3 mb-4">
            <div className="product-image-container">
              <img src={product.photo} alt={product.name} className="product-image img-fluid" />
            </div>
            <h3 className="product-name">{product.name}</h3>
            <p>{t('description')}{product.description}</p>
            <p>{t('category')} {product.category}</p>
            <p>{t('brand')} {product.brand}</p>
            <p>{t('price')}{product.price}</p>
            <p>{t('quantitystock')}{product.quantity}</p>
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
            <label>
            {t('quantity')}
              <input
                type="number"
                value={product.selectedQuantity}
                onChange={(e) => handleQuantityChange(product, parseInt(e.target.value))}
                min={0}
                max={product.quantity}
                className="form-control"
              />
            </label>
            <button
              className="btn btn-success"
              onClick={() => handleAddToCart(product)}
            >
              {t('addtocart')}
            </button>
            <button
          className="btn btn-info"
          onClick={() => handleAddToWishlist(product)}
        >
          {t('addtowish')}
        </button>
          </li>
        ))}
      </ul>
    </main>
  );
}

export default SearchpageT;