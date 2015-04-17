package tn.esprit.bean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Directeur;
import tn.esprit.domain.Employee;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	@EJB
	GestionEmployeeLocal local;
	// DI
	private Part part;
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public String uplod() throws IOException{
		
		byte[] photo=  IOUtils.toByteArray(part.getInputStream());
		employee.setPhoto(photo);
		local.updateEmployee(employee);
		return null;
	}
	private String role;
	private Boolean connected;
	public Boolean getConnected() {
		return connected;
	}
	
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	private String login;
	private String pwd;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private String messge = "";

	public String getMessge() {
		return messge;
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}

	public String valider() {
		messge = "";
		role="";
		connected=false;
		String nav = null;
		employee = local.authentificate(login, pwd);
		if (employee != null) {
			if (employee instanceof Directeur){
				connected=true;
				role="Directeur";
				nav = "/pages/directeur/dashbord?faces-redirect=true";
			}
			else if (employee instanceof Developpeur){
				nav = "/pages/profile?faces-redirect=true";
				connected=true;
				role="Developpeur";
			}
			else{
				connected=true;
				role="Commercial";
				nav = "/pages/profile?faces-redirect=true";
			}
		} else
			messge = "Erreur d'authentification";
		
		System.out.println(nav);
		return nav;

	}
	public void updtae(){
		local.updateEmployee(employee);
		
		
	}
public String deconnexion(){
	
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
	return "/public/login?faces-redirect=true";
	
}
}
