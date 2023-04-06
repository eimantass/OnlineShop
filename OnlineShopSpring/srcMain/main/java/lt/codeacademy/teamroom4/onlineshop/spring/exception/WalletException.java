package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//This class handles WalletExceptions
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WalletException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public WalletException(String message) {
		super(message);
	}
}
