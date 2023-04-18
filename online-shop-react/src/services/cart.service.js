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

}

export default CartService;