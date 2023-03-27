package lt.codeacademy.teamroom4.onlineshop.spring.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	 	
	private String errorMessage;
	private String errorCode;
	
	public static Object builder() {
		
		return null;
	}
	
	
}
