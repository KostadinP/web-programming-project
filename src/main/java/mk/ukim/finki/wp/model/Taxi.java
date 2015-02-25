package mk.ukim.finki.wp.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taxis")
public class Taxi extends BaseEntity{
	
	private String taxiName;
	
	@OneToOne
	private Location taxiLocation;
	
	private String taxiAddress;
	
	@ElementCollection
	private List<String> taxiPhones;
	
	private String taxiInfo;

	public String getTaxiName() {
		return taxiName;
	}

	public void setTaxiName(String taxiName) {
		this.taxiName = taxiName;
	}

	public Location getTaxiLocation() {
		return taxiLocation;
	}

	public void setTaxiLocation(Location taxiLocation) {
		this.taxiLocation = taxiLocation;
	}

	public String getTaxiAddress() {
		return taxiAddress;
	}

	public void setTaxiAddress(String taxiAddress) {
		this.taxiAddress = taxiAddress;
	}

	public List<String> getTaxiPhones() {
		return taxiPhones;
	}

	public void setTaxiPhones(List<String> taxiPhones) {
		this.taxiPhones = taxiPhones;
	}

	public String getTaxiInfo() {
		return taxiInfo;
	}

	public void setTaxiInfo(String taxiInfo) {
		this.taxiInfo = taxiInfo;
	}

	
	
}
