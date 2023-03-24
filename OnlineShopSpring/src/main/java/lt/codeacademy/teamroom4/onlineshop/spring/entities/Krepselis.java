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
@Table(name = "krepselis")
public class Krepselis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToMany
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "eilute_id")
	List<Eilute> eilutes = new ArrayList<>();
	
	public Krepselis() {}

	public Krepselis(Long id, List<Eilute> eilutes) {
		this.id = id;
		this.eilutes = eilutes;
	}

	public Krepselis(List<Eilute> eilutes) {
		this.eilutes = eilutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Eilute> getEilutes() {
		return eilutes;
	}

	public void setEilutes(List<Eilute> eilutes) {
		this.eilutes = eilutes;
	}

	@Override
	public String toString() {
		return "Krepselis [id=" + id + ", eilutes=" + eilutes + "]";
	}
	
}
