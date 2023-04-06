package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//This is Wallet entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
	//Wallet variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name cann't be blank")
	@Size(min = 2, max = 30)
	private String name;
	
	@Size(min = 2, max = 30)
	private String accountNumber;
	
	@Size(max = 100)
	private String description;
	
	@Min(1)
	@Max(3)
	private Integer priority;
	private Double currentBalance;
	// Setters/Getters
	@PrePersist
	public void setBalance() {
		this.currentBalance = new Double(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
