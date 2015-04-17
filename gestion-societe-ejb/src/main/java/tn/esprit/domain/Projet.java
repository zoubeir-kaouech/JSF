package tn.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Projet
 *
 */
@Entity
@Table(name="t_projet")

public class Projet implements Serializable {

	
	private Integer id;
	private String name;
	private Date dateCreation;
	private static final long serialVersionUID = 1L;
	private List<Role> roles;

	public Projet() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	@Column(name="date_creation")
	@Temporal(TemporalType.DATE)
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@OneToMany(mappedBy="projet")
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
