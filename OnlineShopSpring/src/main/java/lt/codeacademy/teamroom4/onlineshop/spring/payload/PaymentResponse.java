package lt.codeacademy.teamroom4.onlineshop.spring.payload;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.PaymentMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
	 	
		private long paymentId;
	    private String status;
	    private PaymentMode paymentMode;
	    private long amount;
	    private Instant paymentDate;
	    private long orderId;
}
