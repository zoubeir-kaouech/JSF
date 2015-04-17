package tn.esprit.services.gestion.projet;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;

@Remote
public interface GestionProjetRemote {
	Boolean addProjet(Projet projet);
	List<Projet> findAllProjets();
	Projet findProjetById(Integer idProjet);
	Boolean asseignProjetToDeveloppeur(Projet projet,Developpeur developpeur,String role,Date date);
List<Projet> findAllProjetsByDeveloppeur(Developpeur  developpeur);
}
