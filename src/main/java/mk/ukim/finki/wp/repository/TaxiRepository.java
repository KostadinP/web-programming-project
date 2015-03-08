package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Taxi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long>{
	
	 Taxi findByTaxiName (String taxiName);
}
