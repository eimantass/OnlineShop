package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import java.util.List;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;

public class CartDto {
	
	Long id;
	List<RecordDto> records;
	
	public CartDto() {}
	
	public CartDto(Cart cart) {
		this.id = cart.getId();
		
		this.records = cart.getEilutes()
				.stream()
				.map(e -> new RecordDto(e))
				.toList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RecordDto> getRecords() {
		return records;
	}

	public void setIrasai(List<RecordDto> records) {
		this.records = records;
	}
	
	public double getTotalPrice() {
		return records
				.stream()
				.mapToDouble(e -> e.getSuma())
				.sum();
	}
	
	public String toString() {
		String atsakymas = "id= " + id + ", suma " + getTotalPrice();
		if(records == null)
			return atsakymas;
		
		for(RecordDto irasas : records) {
			atsakymas += "\n" + irasas;
		}
		return atsakymas;
	}
}
