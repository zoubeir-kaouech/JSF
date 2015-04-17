package tn.esprit.services.gestion.projet;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;

@Local
public interface GestionProjetLocal {
	Boolean addProjet(Projet projet);
	Projet findProjetById(Integer idProjet);
	Boolean asseignProjetToDeveloppeur(Projet projet,Developpeur developpeur,String role,Date date);
	List<Projet> findAllProjetsByDeveloppeur(Developpeur  developpeur);
	List<Projet> findAllProjets();
	Boolean updateProjet(Projet projet);
	Boolean deleteProjet(Projet projet);
}
