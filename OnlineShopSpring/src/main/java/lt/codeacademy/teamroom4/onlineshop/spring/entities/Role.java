package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;
//This is Roles entity
@Entity
@Table(name="roles")
public class Role {
	//Roles variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JoinTable(name = "users")
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERoles name;
	

	//Constructors
	public Role() {
	}
	
	public Role(Integer id, ERoles name) {
		this.id = id;
		this.name = name;
	}
	
	public Role(ERoles name) {
		this.name = name;
	}
	// Setters/Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if(id !=0) {
		this.id = id;
	}
	}
	public ERoles getName() {
		return name;
	}

	public void setName(ERoles name) {
		if(name !=null) {
		this.name = name;
	}
		}
	
}
