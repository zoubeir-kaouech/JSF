package tn.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Employee;

/**
 * Session Bean implementation class GestionEmployee
 */
@Stateless
public class GestionEmployee implements GestionEmployeeRemote,
		GestionEmployeeLocal {
	@PersistenceContext
	EntityManager entityManager;

	public GestionEmployee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEmployee(Employee employee) {
		try {
			entityManager.persist(employee);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		try {
			entityManager.merge(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		try {
			//employee=entityManager.find(Employee.class, employee.getId());
			entityManager.setFlushMode(FlushModeType.AUTO);
			entityManager.remove(entityManager.merge(employee));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee findEmployeeById(Integer idEmployee) {
		Employee employee = null;
		try {
			
			employee = entityManager.find(Employee.class, idEmployee);

			
		} catch (Exception e) {

		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmplloyees() {
		Query query = entityManager.createQuery("select e from Employee e ");
		return query.getResultList();
	}
	@Override
	public List<Developpeur> findAllDeveloppeurs() {
		Query query = entityManager.createQuery("select e from Developpeur e ");
		return query.getResultList();
	}
	@Override
	public Employee authentificate(String login, String pwd) {
		Employee employee=null;
		Query query=entityManager.createQuery("select e from Employee e where e.email=:l and e.pwd=:p");
		query.setParameter("l", login).setParameter("p", pwd);
		try {
			employee=(Employee) query.getSingleResult();
		} catch (Exception e) {
			employee=null;
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployeesByCompetence(Competence competence) {
	Query query=entityManager.createQuery("select e from Employee e where :comp member of e.competences");
	query.setParameter("comp", competence);
	return query.getResultList();
	}

}
