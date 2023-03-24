package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Kategorija;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String pavadinimas;
	double kaina;
	String aprasymas;
	Kategorija kategorija;
	
	public Product() {}

	public Product(String pavadinimas, double kaina, String aprasymas, Kategorija kategorija) {
		this.pavadinimas = pavadinimas;
		this.kaina = kaina;
		this.aprasymas = aprasymas;
		this.kategorija = kategorija;
	}

	public Product(Long id, String pavadinimas, double kaina, String aprasymas, Kategorija kategorija) {
		this.id = id;
		this.pavadinimas = pavadinimas;
		this.kaina = kaina;
		this.aprasymas = aprasymas;
		this.kategorija = kategorija;
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

	public double getKaina() {
		return kaina;
	}

	public void setKaina(double kaina) {
		this.kaina = kaina;
	}

	public String getAprasymas() {
		return aprasymas;
	}

	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pavadinimas=" + pavadinimas + ", kaina=" + kaina + ", aprasymas=" + aprasymas
				+ "]";
	}

}
