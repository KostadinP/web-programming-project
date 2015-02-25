package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class CityMacedonia extends Location{

	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
