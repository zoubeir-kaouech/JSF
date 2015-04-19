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
	@EJB
	GestionEmployeeLocal employeeLocal;

	public Departement findDepartemetById(Integer id) {
		return departementLocal.findDepartementById(id);
	}

//	public boolean existLogin(String login) {
//		return employeeLocal.findLogin(login);
//	}
}
