import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import CartService from "../services/cart.service";
import UserService from "../services/user.service";
import AuthService from "../services/auth.service";
import './css/product-list.css';
import PurchaseService from "../services/purchase.service";

function ProductCart() {
  const navigate = useNavigate();
  const [content, setContent] = useState("");
  const [carts, setCarts] = useState([]);
  const [customerData, setCustomerData] = useState([]);
  const currentUser = AuthService.getCurrentUser();

  useEffect(() => {
    async function fetchData() {
      try {
        const user = JSON.parse(localStorage.getItem('user'));
        const carts = await CartService.GetActiveCarts(user.id);
        
        setCarts(carts);
      } catch (error) {
        console.log(error);
      }
    }

    fetchData();
  }, []);

  useEffect(() => {
    const currentUser = AuthService.getCurrentUser();
    if (currentUser) {
      // Fetch customer data using the current user ID
      UserService.getCustomerByIdMethod(currentUser.id)
        .then((response) => {
          setCustomerData(response.data);
        })
        .catch((error) => {
          setContent(
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
              error.message ||
              error.toString()
          );
        });
    } else {
      // Handle case when no current user is available
      setContent("No current user found.");
    }
  }, []);

  // async function handleRemoveCart(cartId) {
  //   try {
  //     await CartService.deleteCartById(cartId);
  //     const newCarts = carts.filter((cart) => cart.id !== cartId);
  //     setCarts(newCarts);
  //   } catch (error) {
  //     console.log(error);
  //   }
  // }

  async function handleRemoveItem(cartId, itemId) {
    await CartService.removeItemFromCart(cartId, itemId);
    const updatedCarts = await CartService.GetActiveCarts(currentUser.id);
    setCarts(updatedCarts);
  }

  async function handleUpdateQuantity(cartId, itemId, itemQuantity) {
    try {
      const updatedCart = await CartService.UpdateItemQuantityInCart(cartId, itemId, itemQuantity);
      console.log(updatedCart);
      console.debug("UPDT CART: ", updatedCart);
      
      const updatedCarts = await CartService.getAllCartsByUserId(currentUser.id);
      setCarts(updatedCarts);
    } catch (error) {
      console.log(error);
    }
  }

  async function handlePurchase() {
    const user = JSON.parse(localStorage.getItem('user'));
      const carts = await CartService.GetActiveCarts(user.id);
      const sortedCarts = carts.sort((a, b) => new Date(b.date) - new Date(a.date));
      const lastCart = sortedCarts[0];
    try {
      // Check if the customer has enough money to make the purchase
  const totalPrice = carts.reduce((sum, cart) => sum + cart.totalPrice, 0);
  if (totalPrice === 0) {
    // if no products selected, then alert the customer with this message:
    alert("No products selected!");
    return;
  }
  if (customerData.money < totalPrice) {
    // if not enough, then alert the customer with this message:
    alert("Not enough money to make the purchase!");
    return;
  }

      // Create a new purchase for cart
      PurchaseService.createPurchase(customerData.id, lastCart.id)
      // handle success
      .then((data) => {
        console.log("Purchase successful");
        alert("Purchase successful");
        // Redirect to order list
        navigate(`/user-order/${user.id}`);
        //
        window.location.reload();
        
      })
      .catch((error) => {
        console.error(error);
        // handle error
      });
      console.debug("Sending JSON Purchase: ", customerData.id, lastCart.id);
      // create a new cart for user
      
      await CartService.createCartByUserId(customerData.id);


    } catch (error) {
      console.log(error);
      setContent("Error occurred during purchase!");
    }
  }

  // render the list of carts
  return (
    <div>
    {carts.length > 0 ? (
      carts.map((cart) => (
        <div key={cart.id}>
          <div className="col-12 text-center">
            <h2 className="mb-3">Your Cart</h2>
          </div>
          <div className="row">
            {cart.items.length > 0 ? (
              cart.items.map((item) => (
                <div key={item.id} className="col-md-4">
                  <div className="card">
                    <img src={item.product.photo} alt={item.product.name} className="card-img-top" />
                    <div className="card-body">
                      <h5 className="card-title">{item.product.name}</h5>
                      <p className="card-text"><b>Category:</b> {item.product.category}</p>
                      <p className="card-text"><b>Brand:</b> {item.product.brand}</p>
                      <p className="card-text"><b>Price:</b> {item.product.price}</p>
                      <p className="card-text"><b>Description:</b> {item.product.description}</p>
                      <p className="card-text"><b>Quantity in stock:</b> {item.product.quantity}</p>
                      <p className="card-text"><b>Price:</b> {item.product.price}</p>
                      <label>
                        Quantity:
                        <input
                          type="number"
                          value={item.quantity}
                          onChange={(event) => handleUpdateQuantity(cart.id, item.id, event.target.value)}
                          min="0"
                          max={item.product.quantity}
                        />
                      </label>
                      <button onClick={() => handleRemoveItem(cart.id, item.id)} className="btn btn-danger">
                        Remove Item
                      </button>
                      <br></br>
                      <p className="card-text">
                        <h3>
                          <b>Total: {item.sum} </b>
                        </h3>{" "}
                      </p>
                    </div>
                  </div>
                </div>
              ))
            ) : (
              <div className="col-12 text-center">
                <h2>No products in the cart yet!</h2>
              </div>
            )}
          </div>
          {cart.items.length > 0 && (
            <>
              <h3>Total Price: {cart.totalPrice}</h3>
              {currentUser && <h3>Your Wallet: {customerData.money}</h3>}
              <button
                className="btn btn-primary btn-lg"
                type="button"
                onClick={() => {
                  if (window.confirm("Are you sure you want to purchase these items?")) {
                    handlePurchase();
                  }
                }}
              >
                Make a Purchase
              </button>
            </>
          )}
        </div>
      ))
    ) : (
      <h2>No active carts for current user!</h2>
    )}
  </div>
  );
}

export default ProductCart;