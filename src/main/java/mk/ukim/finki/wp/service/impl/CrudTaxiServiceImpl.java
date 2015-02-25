package mk.ukim.finki.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.repository.TaxiRepository;
import mk.ukim.finki.wp.service.CrudTaxiService;

@Service
public class CrudTaxiServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Taxi, TaxiRepository> implements
		CrudTaxiService {
	
	@Autowired
	private TaxiRepository repository;

	@Override
	protected TaxiRepository getRepository() {
		return repository;
	}

}
