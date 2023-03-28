package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToMany
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "eilute_id")
	List<Line> lines = new ArrayList<>();
	
	public Cart() {}

	public Cart(Long id, List<Line> eilutes) {
		this.id = id;
		this.lines = eilutes;
	}

	public Cart(List<Line> eilutes) {
		this.lines = eilutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setEilutes(List<Line> eilutes) {
		this.lines = eilutes;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", lines=" + lines + "]";
	}
	
}
