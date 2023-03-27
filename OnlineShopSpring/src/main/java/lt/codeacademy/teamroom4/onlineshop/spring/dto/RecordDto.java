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
		this.id = line.getPreke().getId();
		this.name = line.getPreke().getPavadinimas();
		this.price = line.getPreke().getKaina();
		this.amount = line.getKiekis();
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

	public void setName(String pavadinimas) {
		this.name = pavadinimas;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int kiekis) {
		this.amount = kiekis;
	}

	public double getSuma() {
		return totalPrice;
	}

	public void setTotalPrice(double suma) {
		this.totalPrice = suma;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double kaina) {
		this.price = kaina;
	}

	@Override
	public String toString() {
		return "IrasasDto [id=" + id + ", pavadinimas=" + name + ", kiekis=" + amount + ", suma=" + totalPrice
				+ ", kaina=" + price + "]";
	}
	
	
}
