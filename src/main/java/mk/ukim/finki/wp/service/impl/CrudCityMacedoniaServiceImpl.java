package mk.ukim.finki.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.repository.CityMacedoniaRepository;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;

@Service
public class CrudCityMacedoniaServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<CityMacedonia, CityMacedoniaRepository>
		implements CrudCityMacedoniaService {

	@Autowired
	private CityMacedoniaRepository repository;
	
	@Override
	protected CityMacedoniaRepository getRepository() {
		return repository;
	}

	@Override
	public CityMacedonia findByLatitudeAndLongitude(float latitude,
			float longitude) {
		return repository.findByLatitudeAndLongitude(latitude, longitude);
	}

}
