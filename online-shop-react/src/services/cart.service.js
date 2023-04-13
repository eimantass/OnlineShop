import axios from "axios";

const CART_API_URL = "http://localhost:8080/cart";

class CartService {
  // Show shopping cart items
  static async showCartItems() {
    try {
      const response = await axios.get(CART_API_URL + "/shoppingCart");
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to get cart items");
    }
  }
// Add item to cart
static async addProductToCart(id, quantity) {
    try {
      const response = await axios.post(CART_API_URL + "/addToCart",  {
        id,
        quantity
      });
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to add item to cart");
    }
  }

  // Remove item from cart
  static async removeProductFromCart(cartItemId) {
    try {
      const response = await axios.delete(`${CART_API_URL}/${cartItemId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to remove item from cart");
    }
  }

  // Update item quantity in cart
  static async updateProductQuantityInCart(cartItemId, quantity) {
    try {
      const response = await axios.put(`${CART_API_URL}/${cartItemId}`, {
        quantity
      });
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to update item quantity in cart");
    }
  }

  // Clear cart
  static async clearCart() {
    try {
      const response = await axios.delete(CART_API_URL);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to clear cart");
    }
  }
}

export default CartService;