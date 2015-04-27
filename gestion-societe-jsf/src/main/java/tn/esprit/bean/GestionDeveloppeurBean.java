package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Departement;
import tn.esprit.domain.Developpeur;
import tn.esprit.services.gestion.departement.GestionDepartementLocal;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;

@ManagedBean
@ViewScoped
public class GestionDeveloppeurBean {
	@EJB
	GestionEmployeeLocal local;
	@EJB
	GestionDepartementLocal departementLocal;
	
	private List<Departement> departements=new ArrayList<Departement>();
	

	public String initialiser(){
		form=true;
		developpeur
		=new Developpeur();
		return null;
	}

	Boolean form = false;

	public Boolean getForm() {
		return form;
	}

	public void setForm(Boolean form) {
		this.form = form;
	}

	private Developpeur developpeur = new Developpeur();

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	@PostConstruct
	public void init() {
		developpeurs = local.findAllDeveloppeurs();
		departements=departementLocal.findAllDepartements();
	
	}

	private List<Developpeur> developpeurs = new ArrayList<Developpeur>();

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	public String doDelete(Developpeur developpeur) {

		local.deleteEmployee(developpeur);
		init();
		return null;
	}

	public void update(Developpeur developpeur) {
		this.developpeur = developpeur;
		form = true;
		System.out.println(developpeur.getCin());
	}
	public String doUpdate(){
		local.updateEmployee(developpeur);
form=false;
		return  null;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
}
