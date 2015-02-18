package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

	private String ime;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
}
