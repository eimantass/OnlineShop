package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lt.codeacademy.teamroom4.onlineshop.spring.payload.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
//	 @ExceptionHandler(PaymentServiceCustomException.class)
//	 public ResponseEntity<ErrorResponse> handleProductServiceException(PaymentServiceCustomException exception) {
//	        return new ResponseEntity<>(ErrorResponse.builder()
//	                .errorMessage(exception.getMessage())
//	                .errorCode(exception.getErrorCode())
//	                .build(), HttpStatus.NOT_FOUND);
//	    }
}
