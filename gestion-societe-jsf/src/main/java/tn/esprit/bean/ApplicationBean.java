package tn.esprit.bean;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.domain.Departement;
import tn.esprit.services.gestion.departement.GestionDepartementLocal;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;

@ManagedBean
@ApplicationScoped
public class ApplicationBean {
	@EJB
	GestionDepartementLocal departementLocal;


	public Departement doFindDepartemetById(Integer id) {
		return departementLocal.findDepartementById(id);
	}
	public Boolean doExistDeperatementByName(String name){
		return departementLocal.existDeperatementByName(name);
	}

//	public boolean existLogin(String login) {
//		return employeeLocal.findLogin(login);
//	}
}
