package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
//DTO
public class RecordDto {
	//DTO variables
	Long id;
	String name;
	int amount;
	double totalPrice;
	double price;
	//Constructs empty record
	public RecordDto() {}
	//Constructs record with data
	public RecordDto(CartItem line) {
		this.id = line.getProduct().getId();
		this.name = line.getProduct().getName();
		this.price = line.getProduct().getPrice();
		this.amount = line.getQuantity();
		this.totalPrice = line.getSum();
	}
	
	public RecordDto(Long id, String name, int amount, double totalPrice, double price) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.price = price;
	}
	// Getters/Setters
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getSuma() {
		return totalPrice;
	}

	public void setTotalPrice(double price) {
		this.totalPrice = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//Returns object in string format
	@Override
	public String toString() {
		return "IrasasDto [id=" + id + ", pavadinimas=" + name + ", kiekis=" + amount + ", suma=" + totalPrice
				+ ", kaina=" + price + "]";
	}
	
	
}
