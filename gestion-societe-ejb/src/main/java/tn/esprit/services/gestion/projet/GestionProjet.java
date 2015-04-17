package tn.esprit.services.gestion.projet;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;
import tn.esprit.domain.Role;

/**
 * Session Bean implementation class GestionProjet
 */
@Stateless
public class GestionProjet implements GestionProjetRemote, GestionProjetLocal {
@PersistenceContext
  EntityManager entityManager;
    public GestionProjet() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addProjet(Projet projet) {
		entityManager.persist(projet);
		return true;
	}

	@Override
	public Projet findProjetById(Integer idProjet) {
		// TODO Auto-generated method stub
		return entityManager.find(Projet.class, idProjet);
	}

	@Override
	public Boolean asseignProjetToDeveloppeur(Projet projet,
			Developpeur developpeur, String role, Date date) {
		Role role2=new  Role(role, projet, developpeur, date);
		entityManager.persist(role2);
		return true;
	}

	@Override
	public List<Projet> findAllProjetsByDeveloppeur(Developpeur developpeur) {
		Query query=entityManager.createQuery("select distinct p from Projet p join p.roles r where r.developpeur=:dep");
		String q="select r.projet from Role r where r.developpeur=:dep";
		query.setParameter("dep", developpeur);
		return query.getResultList();
	}

	@Override
	public List<Projet> findAllProjets() {
		Query query=entityManager.createQuery("select distinct p from Projet p ");
		return query.getResultList();
	}

	@Override
	public Boolean updateProjet(Projet projet) {
		// TODO Auto-generated method stub
		entityManager.merge(projet);
		return true;
	}

	@Override
	public Boolean deleteProjet(Projet projet) {
		entityManager.remove(entityManager.merge(projet));
		return true;
	}
	

}
