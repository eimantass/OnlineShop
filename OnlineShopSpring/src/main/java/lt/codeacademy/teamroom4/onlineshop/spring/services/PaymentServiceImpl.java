package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.TransactionDetails;
import lt.codeacademy.teamroom4.onlineshop.spring.exception.PaymentServiceCustomException;
import lt.codeacademy.teamroom4.onlineshop.spring.payload.PaymentRequest;
import lt.codeacademy.teamroom4.onlineshop.spring.payload.PaymentResponse;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PaymentService;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.TransactionDetailsRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.PaymentMode;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {
//		 TransactionDetails transactionDetails
//         = TransactionDetails.builder()
//         .paymentDate(Instant.now())
//         .paymentMode(paymentRequest.getPaymentMode().name())
//         .paymentStatus("SUCCESS")
//         .orderId(paymentRequest.getOrderId())
//         .referenceNumber(paymentRequest.getReferenceNumber())
//         .amount(paymentRequest.getAmount())
//         .build();
		 
//		 transactionDetails = transactionDetailsRepository.save(transactionDetails);
//		 
//		return transactionDetails.getId();
		//sita return istrinti
		return 4554;
	}

	@Override
	public PaymentResponse getPaymentDetailsByOrderId(long orderId) {
		 TransactionDetails transactionDetails
         = transactionDetailsRepository.findByOrderId(orderId)
         .orElseThrow(() -> new PaymentServiceCustomException(
                 "TransactionDetails with given id not found",
                 "TRANSACTION_NOT_FOUND"));
		 
//		 PaymentResponse paymentResponse
//         = PaymentResponse.builder()
//         .paymentId(transactionDetails.getId())
//         .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
//         .paymentDate(transactionDetails.getPaymentDate())
//         .orderId(transactionDetails.getOrderId())
//         .status(transactionDetails.getPaymentStatus())
//         .amount(transactionDetails.getAmount())
//         .build();

		 return null;
	}

}
