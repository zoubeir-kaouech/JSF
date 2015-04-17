package tn.esprit.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import tn.esprit.domain.Developpeur;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;

@ManagedBean
@ViewScoped
public class InscriptionBean {

	@EJB
	GestionEmployeeLocal local;
	private Developpeur developpeur=new Developpeur();
	public Developpeur getDeveloppeur() {
		return developpeur;
	}
	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	public String addDeveloppeur(){
		System.out.println(developpeur.getEmail());
		local.addEmployee(developpeur);
		return "login?faces-redirect=true";
	}

}
