package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;

public class RecordDto {
	
	Long id;
	String name;
	int amount;
	double totalPrice;
	double price;
	
	public RecordDto() {}
	
	public RecordDto(Line line) {
		this.id = line.getProduct().getId();
		this.name = line.getProduct().getPavadinimas();
		this.price = line.getProduct().getKaina();
		this.amount = line.getAmount();
		this.totalPrice = line.getSuma();
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

	@Override
	public String toString() {
		return "IrasasDto [id=" + id + ", pavadinimas=" + name + ", kiekis=" + amount + ", suma=" + totalPrice
				+ ", kaina=" + price + "]";
	}
	
	
}
