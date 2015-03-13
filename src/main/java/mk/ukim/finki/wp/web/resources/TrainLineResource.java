package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.TrainLine;
import mk.ukim.finki.wp.service.CrudTrainLineService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data/rest/trainLines")
public class TrainLineResource extends CrudResource<TrainLine, CrudTrainLineService>{

	@Autowired
	private CrudTrainLineService service;

	@Override
	public CrudTrainLineService getService() {
		return service;
	}
	
	
}
