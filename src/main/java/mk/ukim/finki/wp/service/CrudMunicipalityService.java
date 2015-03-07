package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Municipality;

public interface CrudMunicipalityService extends BaseEntityCrudService<Municipality>{

	Municipality findByLatitudeAndLongitude(float latitude, float longitude);
}
