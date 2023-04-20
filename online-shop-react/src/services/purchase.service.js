import axios from "axios";

const PURCHASE_API_URL = "http://localhost:8080/purchase";

class PurchaseService {

  // Create Purchase Order
  static async createPurchase(userId, cartId) {
    try {
      const response = await axios.post(`${PURCHASE_API_URL}/buy2/${userId}/${cartId}`);
      return response.data;
    } catch (error) {
      console.log(error);
      throw new Error("Failed to create purchase");
    }
  }
}

export default PurchaseService;