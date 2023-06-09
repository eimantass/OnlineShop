package payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//This class handles registering requests
public class SignupRequest {
	//Request variables
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	private Set<String> role;
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;
	//Constructors
	public SignupRequest() {
	}

	public SignupRequest(@NotBlank @Size(min = 3, max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 40) String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	//Getters/Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
