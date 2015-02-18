package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Professor;
import mk.ukim.finki.wp.service.CrudProfessorService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/data/rest/professors")
public class ProfessorResource extends CrudResource<Professor, CrudProfessorService>{

	@Autowired
	private CrudProfessorService service;
	
	@Override
	public CrudProfessorService getService() {
		// TODO Auto-generated method stub
		return service;
	}

}
