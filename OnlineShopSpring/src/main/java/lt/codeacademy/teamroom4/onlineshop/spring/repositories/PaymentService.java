package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import lt.codeacademy.teamroom4.onlineshop.spring.payload.PaymentRequest;
import lt.codeacademy.teamroom4.onlineshop.spring.payload.PaymentResponse;

public interface PaymentService {
	 
	long doPayment(PaymentRequest paymentRequest);
	PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
