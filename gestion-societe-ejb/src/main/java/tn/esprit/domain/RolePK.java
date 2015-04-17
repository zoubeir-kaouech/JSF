package tn.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class RolePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RolePK() {
		// TODO Auto-generated constructor stub
	}

	private Integer idProjet;
	private Integer idDeveloppeur;
	private Date dateAffectation;

	@Column(name = "id_projet")
	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}

	@Column(name = "id_developpeur")
	public Integer getIdDeveloppeur() {
		return idDeveloppeur;
	}

	public void setIdDeveloppeur(Integer idDeveloppeur) {
		this.idDeveloppeur = idDeveloppeur;
	}

	@Column(name = "date_affectation")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateAffectation == null) ? 0 : dateAffectation.hashCode());
		result = prime * result
				+ ((idDeveloppeur == null) ? 0 : idDeveloppeur.hashCode());
		result = prime * result
				+ ((idProjet == null) ? 0 : idProjet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePK other = (RolePK) obj;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (idDeveloppeur == null) {
			if (other.idDeveloppeur != null)
				return false;
		} else if (!idDeveloppeur.equals(other.idDeveloppeur))
			return false;
		if (idProjet == null) {
			if (other.idProjet != null)
				return false;
		} else if (!idProjet.equals(other.idProjet))
			return false;
		return true;
	}

	public RolePK(Integer idProjet, Integer idDeveloppeur, Date dateAffectation) {
		super();
		this.idProjet = idProjet;
		this.idDeveloppeur = idDeveloppeur;
		this.dateAffectation = dateAffectation;
	}

}
