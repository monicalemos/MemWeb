package pt.memplus.web.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Technician")
public class Technician extends Person{
	
	public Technician() {
		super();
	}

}
