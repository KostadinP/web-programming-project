package mk.ukim.finki.wp.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.service.CrudTaxiService;
import mk.ukim.finki.wp.web.CrudResource;

@RestController
@RequestMapping(value="/data/rest/taxis")
public class TaxiResource extends CrudResource<Taxi, CrudTaxiService>{

	@Autowired
	private CrudTaxiService service;
	
	@Override
	public CrudTaxiService getService() {
		return service;
	}

}
