import axios from "axios";

const CART_API_URL = "http://localhost:8080/cart";

class CartService {

    // Create a cart for the user with the given user ID
    static async createCartByUserId(userId) {
      try {
        const response = await axios.post(`${CART_API_URL}/create/${userId}`);
        return response.data;
      } catch (error) {
        console.log(error);
        throw new Error("Failed to create cart for userId");
      }
    }

  // Retrieve all carts of the user
  static async getAllCartsByUserId() {
    // Here we get the userID
    const getCurrentUser = () => {
      return JSON.parse(localStorage.getItem('user'));
    }
    // We use it to retrieve the cart by UserID
    try {
      const userId = getCurrentUser().id;
      const response = await axios.get(`${CART_API_URL}/cartByUserId/${userId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to get carts by userId");
    }
  }
  // Delete a cart by its ID
static async deleteCartById(cartId) {
  try {
    const response = await axios.delete(`${CART_API_URL}/deleteCart/${cartId}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to delete cart by id");
  }
}

// Add an item to the cart
static async addItemToCart(cartId, itemId, quantity) {
  try {
    const response = await axios.post(`${CART_API_URL}/items/${cartId}/${itemId}/${quantity}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to add item to cart");
  }
}
  
  // Remove an item from the cart
  static async removeItemFromCart(cartId, itemId) {
    try {
      const response = await axios.delete(`${CART_API_URL}/removeItem/${cartId}/${itemId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to remove item from cart");
    }
  }

  // Update item quantity in the cart
  static async UpdateItemQuantityInCart(cartId, itemId, quantity) {
    try {
      const response = await axios.put(`${CART_API_URL}/update/${cartId}/${itemId}/${quantity}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to Update item in cart");
    }
  }

// Get all carts from the repository
static async GetAllCarts() {
  try {
    const response = await axios.get(`${CART_API_URL}/allCarts`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to load all carts");
  }
}

// Get active carts by userID
static async GetActiveCarts(userId) {
  try {
    const response = await axios.get(`${CART_API_URL}/activeCartByUserId/${userId}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to load user active carts");
  }
}

// Get inactive carts by userID
static async GetInactiveCarts(userId) {
  try {
    const response = await axios.get(`${CART_API_URL}/inactiveCartByUserId/${userId}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to load user inactive carts");
  }
}


}

export default CartService;