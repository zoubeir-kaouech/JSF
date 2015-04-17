package tn.esprit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Departement
 *
 */
@Entity
@Table(name = "t_departement")
public class Departement implements Serializable {

	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;
	private Adresse adresse=new Adresse();
	private List<Employee> employees;

	public Departement() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
@OneToMany(mappedBy="departement",cascade={CascadeType.MERGE,CascadeType.PERSIST})
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
public void asseignDepartementToEmployees(List<Employee> employees){
	for(Employee employee:employees)
		employee.setDepartement(this);
	this.employees=employees;
}
}
