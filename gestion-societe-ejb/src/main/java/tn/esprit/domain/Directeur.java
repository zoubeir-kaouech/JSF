package tn.esprit.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Directeur
 *
 */
@Entity
@Table(name="t_directeur")
 @DiscriminatorValue(value="directeur")

public class Directeur extends Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Directeur() {
		super();
	}
   
}
