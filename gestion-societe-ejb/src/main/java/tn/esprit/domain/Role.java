package tn.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

	private String role;
	private RolePK rolePK;
	private static final long serialVersionUID = 1L;

	private Projet projet;

	private Developpeur developpeur;

	public Role() {
		super();
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@EmbeddedId
	public RolePK getRolePK() {
		return this.rolePK;
	}

	public void setRolePK(RolePK rolePK) {
		this.rolePK = rolePK;
	}

	@ManyToOne
	@JoinColumn(name="id_projet",referencedColumnName="id",insertable=false,updatable=false)
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
@ManyToOne
@JoinColumn(name="id_developpeur",referencedColumnName="id",insertable=false,updatable=false)
	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public Role(String role, Projet projet, Developpeur developpeur,Date date) {
		super();
		this.role = role;
		this.projet = projet;
		this.developpeur = developpeur;
		this.rolePK=new RolePK(projet.getId(), developpeur.getId(), date);
	}

}
