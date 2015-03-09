package mk.ukim.finki.wp.service;

import java.util.HashMap;
import java.util.HashSet;

import mk.ukim.finki.wp.model.Taxi;

public interface CrudTaxiService extends BaseEntityCrudService<Taxi> {

	Taxi findByTaxiName(String taxiName);

	HashSet<Integer> findAllasHashSet();
}
