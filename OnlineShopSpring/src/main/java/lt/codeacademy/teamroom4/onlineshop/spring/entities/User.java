package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles;
//This is user entity
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
public class User {
	//User variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=20)
	private String username;
	
	@NotBlank
	@Size(max=50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max=120)
	private String password;
	@NotBlank
	@Size(max=11)
	private long number;
	
	private double money;
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
	   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	//Cosntructors
	public User() {}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.money = MoneyGenerator.virtualMoney();
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.money = MoneyGenerator.virtualMoney();
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.money = MoneyGenerator.virtualMoney();
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 11) long number, double money,
			Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
		this.money = MoneyGenerator.virtualMoney();
		this.roles = roles;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 11) long number, double money,
			Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
		this.money = MoneyGenerator.virtualMoney();
		this.roles = roles;
	}
	
	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 11) long number) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
	}

	// Setters/Getters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
