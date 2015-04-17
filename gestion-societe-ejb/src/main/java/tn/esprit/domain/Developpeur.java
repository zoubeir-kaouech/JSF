package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import tn.esprit.domain.Employee;

/**
 * Entity implementation class for Entity: Developpeur
 *
 */
@Entity
@Table(name="t_developpeur")
@DiscriminatorValue(value="dev")
public class Developpeur extends Employee implements Serializable {

	
	private String matricule;
	private static final long serialVersionUID = 1L;
	private List<Role> roles;

	public Developpeur() {
		super();
	}   
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	@OneToMany(mappedBy="developpeur")
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
   
}
