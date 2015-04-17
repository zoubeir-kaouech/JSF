package tn.esprit.initDb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Employee;

/**
 * Session Bean implementation class InitDB
 */
@Singleton
@LocalBean
@Startup
public class InitDB {

	@PersistenceContext
	EntityManager entityManager

	;

	public InitDB() {
		// TODO Auto-generated constructor stub
	}

	//@PostConstruct
	public void init() {
		Employee employee = new Employee();
		employee.setName("foulen");
		entityManager.persist(employee);
		Developpeur developpeur = new Developpeur();
		developpeur.setName("foulen dev");
		developpeur.setMatricule("123");
		entityManager.persist(developpeur);
		
	}
}
