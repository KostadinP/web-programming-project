package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "citiesDemo")
public class City extends Location {

	private String name;

	@ManyToOne
	private Country country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
