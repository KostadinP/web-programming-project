package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.CityMacedonia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityMacedoniaRepository extends
		JpaRepository<CityMacedonia, Long> {

	CityMacedonia findByLatitudeAndLongitude(float latitude, float longitude);
}
