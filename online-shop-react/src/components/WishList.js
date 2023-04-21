import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import WishListService from "../services/wishlist.service";
import UserService from "../services/user.service";
import './css/product-list.css';
import { useTranslation } from 'react-i18next';
import CartService from "../services/cart.service";

function WishList() {
  const [wishLists, setWishLists] = useState([]);
  const [customerData, setCustomerData] = useState([]);
  const [cartMessage, setCartMessage] = useState("");
  const currentUser = JSON.parse(localStorage.getItem('user'));
  const navigate = useNavigate();
  const { t } = useTranslation();

  useEffect(() => {
    async function fetchData() {
      try {
        const wishLists = await WishListService.getAllWishListsByUserId(currentUser.id);
        setWishLists(wishLists);
      } catch (error) {
        console.log(error);
      }
    }

    fetchData();
  }, [currentUser.id]);

  useEffect(() => {
    const currentUser = JSON.parse(localStorage.getItem('user'));
    if (currentUser) {
      // Fetch customer data using the current user ID
      UserService.getCustomerByIdMethod(currentUser.id)
        .then((response) => {
          setCustomerData(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, []);

  async function handleRemoveItem(wishListId, itemId) {
    try {
      await WishListService.removeItemFromWishList(wishListId, itemId);
      const updatedWishLists = wishLists.map((wishList) => {
        if (wishList.id === wishListId) {
          const updatedItems = wishList.items.filter((item) => item.id !== itemId);
          return {
            ...wishList,
            items: updatedItems
          };
        }
        return wishList;
      });
      setWishLists(updatedWishLists);
    } catch (error) {
      console.log(error);
    }
  }

  async function handleAddToCart(productId, quantity) {
    if (currentUser) {
      try {

        const carts = await CartService.GetActiveCarts(currentUser.id);
  
      let cart;
      let cartMessage;
  
      if (!carts || carts.length === 0) {
        cart = await CartService.createCartByUserId(currentUser.id);
        cartMessage = "Cart created successfully!";
      } else {
        carts.sort((a, b) => b.createdAt - a.createdAt);
        cart = carts[0];
        cartMessage = "You already have an active cart!";
      }
        const response = await CartService.addItemToCart(cart.id, productId, quantity);
        setCartMessage(response.data.message);
        console.debug("Sending JSON: ", cart.id, quantity, currentUser.id);
        
      } catch (error) {
        console.log(error);
      }
    } else {
      // redirect to login page if the user is not logged in
      navigate("/login");
    }

    
  }
//Remove whole wish list

  // async function handleRemoveWishList(wishListId) {
  //   try {
  //     await WishListService.deleteWishListById(wishListId);
  //     const newWishLists = wishLists.filter((wishList) => wishList.id !== wishListId);
  //     setWishLists(newWishLists);
  //   } catch (error) {
  //     console.log(error);
  //   }
  // }

  // render the list of wish lists
  // const { t } = useTranslation();
  return (
<div className="container">
  {wishLists.length > 0 ? (
    wishLists.map((wishList) => (
      <div key={wishList.id} className="my-4">
        <div className="col-12 text-center">
        <h2 className="mb-3">{t('wishList')}</h2>
        </div>
        {/* Remove wishlist button */}
        {/* <button onClick={() => handleRemoveWishList(wishList.id)}>Remove Wishlist</button> */}
        <div className="row">
          {wishList.items.length > 0 ? (
            wishList.items.map((item) => (
              <div key={item.id} className="col-md-4">
                <div className="card">
                  <img src={item.product.photo} alt={item.product.name} className="card-img-top" />
                  <div className="card-body">
                    <h5 className="card-title">{item.product.name}</h5>
                    <p className="card-text">{t('category')} {item.product.category}</p>
                    <p className="card-text">{t('brand')} {item.product.brand}</p>
                    <p className="card-text">{t('quantitystock')}  {item.product.quantity}</p>
                    <p className="card-text">{t('price')} {item.product.price}</p>
                    <p className="card-text">{t('description')} {item.product.description}</p>
                    <button onClick={() => handleRemoveItem(wishList.id, item.id)} className="btn btn-danger">{t('removefromwish')}</button>
                    <div className="input-group mt-2">
                      <input
                        type="number"
                        className="form-control"
                        placeholder={t('quantity')}
                        value={item.quantity}
                        min="1"
                        max={item.product.quantity}
                        onChange={(e) => {
                          const updatedQuantity = e.target.value;
                          const updatedItems = wishList.items.map((wishListItem) => {
                            if (wishListItem.id === item.id) {
                              return {
                                ...wishListItem,
                                quantity: updatedQuantity
                              };
                            }
                            return wishListItem;
                          });
                          const updatedWishList = {
                            ...wishList,
                            items: updatedItems
                          };
                          const updatedWishLists = wishLists.map((wl) => {
                            if (wl.id === wishList.id) {
                              return updatedWishList;
                            }
                            return wl;
                          });
                          setWishLists(updatedWishLists);
                        }}
                      />
                      <button
                          className="btn btn-primary"
                          onClick={() => handleAddToCart(item.product.id, item.quantity)}
                        >
                          {t('addtocart')}
                        </button>
                    </div>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <div className="col-12 text-center">
              <h3>{t('noitemswish')}</h3>
            </div>
          )}
        </div>
      </div>
    ))
  ) : (
    <div className="col-12 text-center">
    <h2>{t('noactivewish')}</h2>
    </div>
  )}
</div>
  );
}
export default WishList;