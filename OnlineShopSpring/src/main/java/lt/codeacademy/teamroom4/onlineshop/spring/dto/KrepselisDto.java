package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import java.util.List;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;

public class KrepselisDto {
	
	Long id;
	List<IrasasDto> irasai;
	
	public KrepselisDto() {}
	
	public KrepselisDto(Cart krepselis) {
		this.id = krepselis.getId();
		
		this.irasai = krepselis.getEilutes()
				.stream()
				.map(e -> new IrasasDto(e))
				.toList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IrasasDto> getIrasai() {
		return irasai;
	}

	public void setIrasai(List<IrasasDto> irasai) {
		this.irasai = irasai;
	}
	
	public double getSuma() {
		return irasai
				.stream()
				.mapToDouble(e -> e.getSuma())
				.sum();
	}
	
	public String toString() {
		String atsakymas = "id= " + id + ", suma " + getSuma();
		if(irasai == null)
			return atsakymas;
		
		for(IrasasDto irasas : irasai) {
			atsakymas += "\n" + irasas;
		}
		return atsakymas;
	}
}
