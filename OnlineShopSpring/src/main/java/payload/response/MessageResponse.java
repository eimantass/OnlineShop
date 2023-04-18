package payload.response;
//This class handles message response payload.
public class MessageResponse {
	private String message;
	//Message constructor
	public MessageResponse(String message) {
		this.message = message;
	}
	//Getters/Setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
