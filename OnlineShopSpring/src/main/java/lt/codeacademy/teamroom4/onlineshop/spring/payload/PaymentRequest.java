package lt.codeacademy.teamroom4.onlineshop.spring.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.PaymentMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
		
		private long orderId;
	    private long amount;
	    private String referenceNumber;
	    private PaymentMode paymentMode;
		public long getOrderId() {
			return orderId;
		}
		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}
		public long getAmount() {
			return amount;
		}
		public void setAmount(long amount) {
			this.amount = amount;
		}
		public String getReferenceNumber() {
			return referenceNumber;
		}
		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}
		public PaymentMode getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(PaymentMode paymentMode) {
			this.paymentMode = paymentMode;
		}
	    
	    
}
