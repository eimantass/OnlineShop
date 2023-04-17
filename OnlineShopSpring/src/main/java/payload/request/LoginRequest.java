package payload.request;

import javax.validation.constraints.NotBlank;

//This class handles login requests
public class LoginRequest {
	//Request variables
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	//Constructors
	public LoginRequest() {
	}

	public LoginRequest(@NotBlank String username, @NotBlank String password) {
		this.username = username;
		this.password = password;
	}
	//Getters/Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
