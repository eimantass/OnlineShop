package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	private String name; 
	
	@Lob 
	private byte[] data;
	
	public Photo() {}

	public Photo(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}

	public Photo(Long id, String name, byte[] data) {
		this.id = id;
		this.name = name;
		this.data = data;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
}
