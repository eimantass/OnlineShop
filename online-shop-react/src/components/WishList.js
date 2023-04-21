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
  return (
<div className="container">
  {wishLists.length > 0 ? (
    wishLists.map((wishList) => (
      <div key={wishList.id} className="my-4">
        <div className="col-12 text-center">
        <h2 className="mb-3">Your Wish List</h2>
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
                    <p className="card-text">Category: {item.product.category}</p>
                    <p className="card-text">Brand: {item.product.brand}</p>
                    <p className="card-text">Quantity in stock: {item.product.quantity}</p>
                    <p className="card-text">Price: {item.product.price}</p>
                    <p className="card-text">Description: {item.product.description}</p>
                    <button onClick={() => handleRemoveItem(wishList.id, item.id)} className="btn btn-danger">Remove from Wish List</button>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <div className="col-12 text-center">
              <h3>No items in this Wish List!</h3>
            </div>
          )}
        </div>
      </div>
    ))
  ) : (
    <div className="col-12 text-center">
    <h2>No active Wish Lists for current user!</h2>
    </div>
  )}
</div>
  );
}

export default WishList;