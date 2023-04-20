import axios from "axios";

const PURCHASE_API_URL = "http://localhost:8080/purchase";

class PurchaseService {

    // Create Purchase Order
    static async createPurchase(userId) {
      try {
        const response = await axios.post(`${PURCHASE_API_URL}`);
        return response.data;
      } catch (error) {
        console.log(error);
        throw new Error("Failed to create cart for userId");
      }
    }
}

export default PurchaseService;