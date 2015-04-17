package tn.esprit.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Commercial
 * 
 */
@Entity
@Table(name = "t_commercial")
@DiscriminatorValue(value = "commercial")
public class Commercial extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	public Commercial() {
		super(); 
	}

}
