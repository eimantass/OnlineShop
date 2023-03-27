package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;

public class RecordDto {
	
	Long id;
	String pavadinimas;
	int kiekis;
	double suma;
	double kaina;
	
	public RecordDto() {}
	
	public RecordDto(Line eilute) {
		this.id = eilute.getPreke().getId();
		this.pavadinimas = eilute.getPreke().getPavadinimas();
		this.kaina = eilute.getPreke().getKaina();
		this.kiekis = eilute.getKiekis();
		this.suma = eilute.getSuma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public int getKiekis() {
		return kiekis;
	}

	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public double getKaina() {
		return kaina;
	}

	public void setKaina(double kaina) {
		this.kaina = kaina;
	}

	@Override
	public String toString() {
		return "IrasasDto [id=" + id + ", pavadinimas=" + pavadinimas + ", kiekis=" + kiekis + ", suma=" + suma
				+ ", kaina=" + kaina + "]";
	}
	
	
}
