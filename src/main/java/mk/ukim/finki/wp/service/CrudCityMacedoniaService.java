package mk.ukim.finki.wp.service;

import java.util.HashMap;
import java.util.HashSet;

import mk.ukim.finki.wp.model.CityMacedonia;

public interface CrudCityMacedoniaService extends
		BaseEntityCrudService<CityMacedonia> {

	CityMacedonia findByLatitudeAndLongitude(double latitude, double longitude);

	HashSet<CityMacedonia> findAllasHashSet();
	
	HashMap<Integer,CityMacedonia> findAllasHashMap();
}
