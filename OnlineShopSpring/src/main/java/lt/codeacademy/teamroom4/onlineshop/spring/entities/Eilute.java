package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Eilute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	int kiekis;
	Product preke;
	
	public Eilute() {}
	
	public Eilute(int kiekis, Product preke) {
		super();
		this.kiekis = kiekis;
		this.preke = preke;
	}

	public Eilute(Long id, int kiekis, Product preke) {
		this.id = id;
		this.kiekis = kiekis;
		this.preke = preke;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKiekis() {
		return kiekis;
	}

	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

	public Product getPreke() {
		return preke;
	}

	public void setPreke(Product preke) {
		this.preke = preke;
	}

	@Override
	public String toString() {
		return "Eilute [id=" + id + ", kiekis=" + kiekis + ", preke=" + preke + "]";
	}
	
	
	
	
}
