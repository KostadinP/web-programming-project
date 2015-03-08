package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.CityMacedonia;

public interface CrudCityMacedoniaService extends
		BaseEntityCrudService<CityMacedonia> {

	CityMacedonia findByLatitudeAndLongitude(double latitude, double longitude);
}
