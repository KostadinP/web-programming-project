package mk.ukim.finki.wp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
	public CityMacedonia findByLatitudeAndLongitude(double latitude,
			double longitude) {
		return repository.findByLatitudeAndLongitude(latitude, longitude);
	}

	@Override
	public HashSet<CityMacedonia> findAllasHashSet() {
		List<CityMacedonia> cityList = repository.findAll();
		HashSet<CityMacedonia> hashSet = new HashSet<CityMacedonia>();

		for (CityMacedonia cityMacedonia : cityList) {
			hashSet.add(cityMacedonia);
		}
		return hashSet;
	}

	@Override
	public HashMap<Integer, CityMacedonia> findAllasHashMap() {
		List<CityMacedonia> cityList = repository.findAll();
		HashMap<Integer,CityMacedonia> hashMap = new HashMap<Integer,CityMacedonia>();

		for (CityMacedonia cityMacedonia : cityList) {
			hashMap.put(cityMacedonia.hashCode(), cityMacedonia);
		}
		return hashMap;
	}

}
