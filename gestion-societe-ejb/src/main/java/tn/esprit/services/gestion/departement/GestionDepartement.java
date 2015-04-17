package tn.esprit.services.gestion.departement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Departement;

/**
 * Session Bean implementation class GestionDepartement
 */
@Stateless
public class GestionDepartement implements GestionDepartementRemote, GestionDepartementLocal {
	
	@PersistenceContext
	EntityManager entityManager;

	public GestionDepartement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addDepartement(Departement departement) {
		try {
			entityManager.persist(departement);
			
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean updateDepartement(Departement departement) {
		try {
			entityManager.merge(departement);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteDepartement(Departement departement) {
		try {
			//departement=entityManager.find(Departement.class, departement.getId());
			entityManager.setFlushMode(FlushModeType.AUTO);
			entityManager.remove(entityManager.merge(departement));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Departement findDepartementById(Integer idDepartement) {
		Departement departement = null;
		try {
			
			departement = entityManager.find(Departement.class, idDepartement);

		} catch (Exception e) {

		}
		return departement;
	}

	@Override
	public List<Departement> findAllDepartements() {
		Query query = entityManager.createQuery("select e from Departement e ");
		return query.getResultList();
	}
}
