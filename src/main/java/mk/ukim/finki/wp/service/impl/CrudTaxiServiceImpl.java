package mk.ukim.finki.wp.service.impl;

import java.util.HashSet;
import java.util.List;

import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.repository.TaxiRepository;
import mk.ukim.finki.wp.service.CrudTaxiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Taxi findByTaxiName(String taxiName) {
		return repository.findByTaxiName(taxiName);
	}

	@Override
	public HashSet<Integer> findAllasHashSet() {

		List<Taxi>taxiList = repository.findAll();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (Taxi taxi : taxiList) {
			hashSet.add(taxi.hashCode());
		}
		return hashSet;
	}

}
