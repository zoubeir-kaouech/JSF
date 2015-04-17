package tn.esprit.services.gestion.competence;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;
import tn.esprit.services.gestion.employee.GestionEmployeeLocal;

/**
 * Session Bean implementation class GestionCompetence
 */
@Stateless
public class GestionCompetence implements GestionCompetenceRemote, GestionCompetenceLocal {
	
	@PersistenceContext
	EntityManager entityManager;
	@EJB
GestionEmployeeLocal employeeLocal;
	public GestionCompetence() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addCompetence(Competence competence) {
		try {
			entityManager.persist(competence);
			
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean updateCompetence(Competence competence) {
		try {
			entityManager.merge(competence);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteCompetence(Competence competence) {
		try {
			List<Employee> employees=employeeLocal.findAllEmployeesByCompetence(competence);
			for(Employee employee:employees){
				List<Competence> competences=findAllCompetencesByEmployee(employee);
				competences.remove(competence);
				employee.setCompetences(competences);
				entityManager.merge(employee);
			}
			//competence=entityManager.find(Competence.class, competence.getId());
		
			entityManager.remove(entityManager.merge(competence));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Competence findCompetenceById(Integer idCompetence) {
		Competence competence = null;
		try {
			
			competence = entityManager.find(Competence.class, idCompetence);

		} catch (Exception e) {

		}
		return competence;
	}

	@Override
	public List<Competence> findAllEmplloyees() {
		Query query = entityManager.createQuery("select e from Competence e ");
		return query.getResultList();
	}

	@Override
	public List<Competence> findAllCompetencesByEmployee(Employee employee) {
		Query  query=entityManager.createQuery("select c from Competence c where"
				+ " :emp member of c.employees");
		query.setParameter("emp", employee);
		return query.getResultList();
	}

}
