package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Municipality extends Location{

	private String municipalityName;
	
	@OneToOne
	private CityMacedonia municipalityCity;

	public String getMunicipalityName() {
		return municipalityName;
	}

	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}

	public CityMacedonia getMunicipalityCity() {
		return municipalityCity;
	}

	public void setMunicipalityCity(CityMacedonia municipalityCity) {
		this.municipalityCity = municipalityCity;
	}
	
	
}
