package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.domain.Adresse;
import tn.esprit.domain.Departement;
import tn.esprit.services.gestion.departement.GestionDepartementLocal;

@ManagedBean
@ViewScoped
public class GestionDepartementBean {

	@EJB
	GestionDepartementLocal local;
	private Departement departement = new Departement();
	private List<Departement> departements = new ArrayList<Departement>();
	private Boolean form;
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean form) {
		this.form = form;
	}

	public String initialisation(){
		form=true;
		departement=new Departement();
		departement.setAdresse(new Adresse());
		return null;
	}
	@PostConstruct
	public void init() {
form=false;
		departement = new Departement();
		departement.setAdresse(new Adresse());
		departements = local.findAllDepartements();
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	public String doUpdateDepartement() {
		FacesMessage message;
		if(local.updateDepartement(departement)){
		
		 message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec succès",null);
		
		init();
		}else{
			 message=new FacesMessage(FacesMessage.SEVERITY_ERROR
					 ,"Erreur",null);
				
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}

	public String doDelete(Departement departement) throws InterruptedException {
		local.deleteDepartement(departement);
		Thread.sleep(10000);
		init();
		return null;
	}
}
