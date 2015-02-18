package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

	@NotEmpty
	private String ime;

	@NotEmpty
	private String prezime;

	@NotEmpty
	private String indeks;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	@Override
	public String toString() {
		return ime;
	}
	
	
}
