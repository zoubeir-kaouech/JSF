package tn.esprit.services.gestion.departement;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Departement;

@Remote
public interface GestionDepartementRemote {
	Boolean addDepartement(Departement departement);
	Boolean updateDepartement(Departement departement);
	Boolean deleteDepartement(Departement departement);
	Departement findDepartementById(Integer idDepartement);
	List<Departement> findAllDepartements();
}
