package payload.response;

import java.util.List;

public class JwtResponse {
private String token;
private String type = "Bearer";
private Long id;
private String username;
private String email;
private List<String> roles;
public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
	super();
	this.token = token;
	this.id = id;
	this.username = username;
	this.email = email;
	this.roles = roles;
}
public String getAccessToken() {
	return token;
}
public void setAccessToken(String token) {
	this.token = token;
}
public String getTokenType() {
	return type;
}
public void setTokenType(String type) {
	this.type = type;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
public List<String> getRoles() {
	return roles;
}
public void setRoles(List<String> roles) {
	this.roles = roles;
}


}
