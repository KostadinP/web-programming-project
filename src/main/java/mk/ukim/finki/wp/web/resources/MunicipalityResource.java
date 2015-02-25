package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Municipality;
import mk.ukim.finki.wp.service.CrudMunicipalityService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data/rest/municipalities")
public class MunicipalityResource extends CrudResource<Municipality, CrudMunicipalityService>{

	@Autowired
	private CrudMunicipalityService service;
	
	@Override
	public CrudMunicipalityService getService() {
		return service;
	}

}
