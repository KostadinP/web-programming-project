package mk.ukim.finki.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Municipality;
import mk.ukim.finki.wp.repository.MunicipalityRepository;
import mk.ukim.finki.wp.service.CrudMunicipalityService;

@Service
public class CrudMunicipalityServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Municipality, MunicipalityRepository>
		implements CrudMunicipalityService {

	@Autowired
	private MunicipalityRepository repository;
	
	@Override
	protected MunicipalityRepository getRepository() {
		return repository;
	}

	@Override
	public Municipality findByLatitudeAndLongitude(float latitude,
			float longitude) {
		return repository.findByLatitudeAndLongitude(latitude, longitude);
	}
	
	
}
