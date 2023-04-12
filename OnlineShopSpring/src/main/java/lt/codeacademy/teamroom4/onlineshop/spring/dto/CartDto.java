package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import java.util.List;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
//DTO
public class CartDto {
	//DTO variables
	Long id;
	List<RecordDto> records;
	//Constructing empty CartDto
	public CartDto() {}
	
	public CartDto(Long id, List<RecordDto> records) {
		this.id = id;
		this.records = records;
	}

	//Getters and Setters
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
	//Returns total price
	public String toString() {
		String answer = "id= " + id + ", suma " + getTotalPrice();
		if(records == null)
			return answer;
		
		for(RecordDto record : records) {
			answer += "\n" + record;
		}
		return answer;
	}
}
