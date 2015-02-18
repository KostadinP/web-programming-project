package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Grade;
import mk.ukim.finki.wp.service.CrudGradeService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data/rest/grades")
public class GradeResource extends CrudResource<Grade, CrudGradeService>{

	@Autowired
	private CrudGradeService service;
	
	@Override
	public CrudGradeService getService() {
		return service;
	}

}
