package tn.esprit.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;
import tn.esprit.services.gestion.projet.GestionProjetLocal;

@ManagedBean
@ViewScoped
public class GestionProjet {
	@EJB
	GestionEmployeeLocal employeeLocal;
	
	@EJB
	GestionProjetLocal local;
	private List<Developpeur> developpeurs;
	Boolean form;
	Boolean form2;
	public Boolean getForm2() {
		return form2;
	}
	public void setForm2(Boolean form2) {
		this.form2 = form2;
	}
	Boolean form1;
	public Boolean getForm1() {
		return form1;
	}
	public void setForm1(Boolean form1) {
		this.form1 = form1;
	}
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean form) {
		this.form = form;
	}
	private List<Projet> projets = new ArrayList<Projet>();
	private Projet projet = new Projet();

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
private Developpeur developpeur=new  Developpeur();
public Developpeur getDeveloppeur() {
	return developpeur;
}
public void setDeveloppeur(Developpeur developpeur) {
	this.developpeur = developpeur;
}
	@PostConstruct
	public void init() {
		form=false;
		form=false;
		projet=new Projet();
		projets = local.findAllProjets();
	}

	public String  doFindAll(){
		developpeurs=new ArrayList<Developpeur>();
		developpeurs=employeeLocal.findAllDeveloppeurs();
		form1=true;
		form=false;
		return null;
	}
	public String doUpdate() {
		local.updateProjet(projet);
init();
		return null;
	}

	public String doDeleteProjet(Projet projet) {
		local.deleteProjet(projet);
		init();
		return null;

	}
public String initialiser(){
	form=true;
	projet=new Projet();
	return null;
}
public List<Developpeur> getDeveloppeurs() {
	return developpeurs;
}
public void setDeveloppeurs(List<Developpeur> developpeurs) {
	this.developpeurs = developpeurs;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
private String role;
private Date date;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String doAffect(){
	local.asseignProjetToDeveloppeur(projet, developpeur, role, date);
	form1=false;
	form2=false;
	return null;
}
}
