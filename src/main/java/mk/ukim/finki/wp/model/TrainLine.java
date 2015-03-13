package mk.ukim.finki.wp.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainLines")
public class TrainLine extends BaseEntity{

	@ManyToOne
	private CityMacedonia departureCity;
	
	@ManyToOne
	private CityMacedonia arrivalCity;
	
	private Time departureTime;
	
	private Time arrivalTime;
	
	private int ticketPrice;

	public CityMacedonia getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(CityMacedonia departureCity) {
		this.departureCity = departureCity;
	}

	public CityMacedonia getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(CityMacedonia arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
