package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data/rest/citiesMacedonia")
public class CityMacedoniaResource extends CrudResource<CityMacedonia, CrudCityMacedoniaService>{

	@Autowired
	private CrudCityMacedoniaService service;
	
	@Override
	public CrudCityMacedoniaService getService() {
		return service;
	}

}
