import axios from "axios";

const CART_API_URL = "http://localhost:8080/wish-list";

class WishListService {

    // Create a cart for the user with the given user ID
    static async createWishListByUserId(userId) {
      try {
        const response = await axios.post(`${CART_API_URL}/create/${userId}`);
        return response.data;
      } catch (error) {
        console.log(error);
        throw new Error("Failed to wishlist cart for userId");
      }
    }

  // Retrieve all carts of the user
  static async getAllWishListsByUserId() {
    // Here we get the userID
    const getCurrentUser = () => {
      return JSON.parse(localStorage.getItem('user'));
    }
    // We use it to retrieve the wishlist by UserID
    try {
      const userId = getCurrentUser().id;
      const response = await axios.get(`${CART_API_URL}/wishListByUserId/${userId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to get wishlist by userId");
    }
  }
  // Delete a wishlist by its ID
static async deleteWishListById(wishlistId) {
  try {
    const response = await axios.delete(`${CART_API_URL}/deleteWishlist/${wishlistId}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to delete wishlist by id");
  }
}

// Add an item to the wishList
static async addItemToWishList(WishListId, itemId) {
  try {
    const response = await axios.post(`${CART_API_URL}/items/${WishListId}/${itemId}`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to add item to wishlist");
  }
}
  
  // Remove an item from the wishlist
  static async removeItemFromWishList(WishListId, itemId) {
    try {
      const response = await axios.delete(`${CART_API_URL}/removeItem/${WishListId}/${itemId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to remove item from wishlist");
    }
  }

// Get all wishlists from the repository
static async GetAllWishLists() {
  try {
    const response = await axios.get(`${CART_API_URL}/allWishLists`);
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error("Failed to load all wishlists");
  }
}

}

export default WishListService;