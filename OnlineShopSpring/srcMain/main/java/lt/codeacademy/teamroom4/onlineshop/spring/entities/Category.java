package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;
//This is category entity
@Entity
@Table(name = "category")
public class Category {
	//Variables...
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Categories name;
	//Constructs categories
	public Category(Categories name) {
		this.name = name;
	}

	public Category() {
	}
	// Getters/Setters
	public Long getId() {
		return id;
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categories getName() {
		return name;
	}
	public void setName(Categories name) {
		this.name = name;
	}
	
}
