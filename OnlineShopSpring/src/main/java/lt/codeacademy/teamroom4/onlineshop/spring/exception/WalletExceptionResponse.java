package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
//This class handles WalletException responses
@Data
@AllArgsConstructor
public class WalletExceptionResponse {
	private String id;
	
	public WalletExceptionResponse(String id) {
		this.id = id;
	}

	public String getErrorMessage() {
		return id;
	}
}
