package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Employee;
import tn.esprit.domain.Projet;
import tn.esprit.services.gestion.projet.GestionProjetLocal;

@ManagedBean
@ViewScoped
public class ProjetsBean {
	@EJB
	GestionProjetLocal local;
	private List<Projet> projetsFiltred;
	public List<Projet> getProjetsFiltred() {
		return projetsFiltred;
	}
	public void setProjetsFiltred(List<Projet> projetsFiltred) {
		this.projetsFiltred = projetsFiltred;
	}
	private List<Projet> projets = new ArrayList<Projet>();

	public List<Projet> getProjets() {
		return projets;
	}
	@ManagedProperty("#{loginBean.employee}")
private Employee employee;
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	@PostConstruct
	
	public void init(){
		projets=local.findAllProjetsByDeveloppeur((Developpeur) employee);
	}
}
