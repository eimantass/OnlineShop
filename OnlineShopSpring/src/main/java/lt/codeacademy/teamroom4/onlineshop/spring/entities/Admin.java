package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String fullName;
	
	@NotNull
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
	
	private String matchingPassword;
	
	private String role;
	
	public Admin(){}

	public Admin(Long id, @NotNull @NotEmpty String fullName, @NotNull @NotEmpty String email,
			@NotNull @NotEmpty String password, String matchingPassword, String role) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.role = role;
	}
	

	public Admin(@NotNull @NotEmpty String fullName, @NotNull @NotEmpty String email,
			@NotNull @NotEmpty String password, String matchingPassword, String role) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", matchingPassword=" + matchingPassword + ", role=" + role + "]";
	}

	
	
}
