package mk.ukim.finki.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.TrainLine;
import mk.ukim.finki.wp.repository.TrainLineRepository;
import mk.ukim.finki.wp.service.CrudTrainLineService;

@Service
public class CrudTrainLineServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<TrainLine, TrainLineRepository>
		implements CrudTrainLineService {

	@Autowired
	TrainLineRepository repository;
	
	@Override
	protected TrainLineRepository getRepository() {
		return repository;
	}

}
