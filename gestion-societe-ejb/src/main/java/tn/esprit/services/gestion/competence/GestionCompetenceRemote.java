package tn.esprit.services.gestion.competence;

import java.util.List;

import javax.ejb.Remote;
import javax.faces.event.ListenersFor;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;

@Remote
public interface GestionCompetenceRemote {
	Boolean addCompetence(Competence competence);
	Boolean updateCompetence(Competence competence);
	Boolean deleteCompetence(Competence competence);
	Competence findCompetenceById(Integer idCompetence);
	List<Competence> findAllEmplloyees();
	List<Competence> findAllCompetencesByEmployee(Employee employee);

}
