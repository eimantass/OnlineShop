import React, { useState, useEffect } from "react";
import WishListService from "../services/wishlist.service";
import UserService from "../services/user.service";
import './css/product-list.css';

function WishList() {
  const [wishLists, setWishLists] = useState([]);
  const [customerData, setCustomerData] = useState([]);
  const currentUser = JSON.parse(localStorage.getItem('user'));

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

  async function handleRemoveWishList(wishListId) {
    try {
      await WishListService.deleteWishListById(wishListId);
      const newWishLists = wishLists.filter((wishList) => wishList.id !== wishListId);
      setWishLists(newWishLists);
    } catch (error) {
      console.log(error);
    }
  }

  // render the list of wish lists
  return (
    <div>
      {wishLists.length > 0 ? (
        wishLists.map((wishList) => (
          <div key={wishList.id}>
            <h2>WishList Id: {wishList.id}</h2>
            <button onClick={() => handleRemoveWishList(wishList.id)}>Remove Wishlist</button>
            <p>User Id: {wishList.user.id}</p>
            <ul>
              {wishList.items.map((item) => (
                <li key={item.id}>
                     <img src={item.product.photo} alt={item.product.name} />
                  <h3>{item.product.name}</h3>
                 
                  <p>Price: {item.product.price}</p>
                  <button onClick={() => handleRemoveItem(wishList.id, item.id)}>Remove Item</button>
                </li>
              ))}
            </ul>
        
            
          </div>
        ))
      ) : (
        <h2>No active Wish Lists for current user!</h2>
      )}
    </div>
  );
}

export default WishList;