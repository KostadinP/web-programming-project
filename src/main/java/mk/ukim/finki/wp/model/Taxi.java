package mk.ukim.finki.wp.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taxis")
public class Taxi extends BaseEntity{
	
	private String taxiName;
	
	@OneToOne
	private Location taxiLocation;
	
	private String taxiAddress;
	
	@ElementCollection(fetch = FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result;
		result = prime 
				+ ((taxiName == null) ? 0 : taxiName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Taxi other = (Taxi) obj;
		if (taxiName == null) {
			if (other.taxiName != null)
				return false;
		} else if (!taxiName.equals(other.taxiName))
			return false;
		return true;
	}

	




		
	
	
}
