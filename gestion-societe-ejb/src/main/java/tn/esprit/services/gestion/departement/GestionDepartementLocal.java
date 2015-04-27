package tn.esprit.services.gestion.departement;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Departement;

@Local
public interface GestionDepartementLocal {
	Boolean addDepartement(Departement departement);
	Boolean updateDepartement(Departement departement);
	Boolean deleteDepartement(Departement departement);
	Departement findDepartementById(Integer idDepartement);
	List<Departement> findAllDepartements();
	Boolean existDeperatementByName(String name);
}
