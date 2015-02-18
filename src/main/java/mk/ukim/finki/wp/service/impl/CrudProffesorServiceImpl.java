package mk.ukim.finki.wp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Professor;
import mk.ukim.finki.wp.repository.ProfessorRepository;
import mk.ukim.finki.wp.service.CrudProfessorService;

@Service
public class CrudProffesorServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Professor, ProfessorRepository>
		implements CrudProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	
	@Override
	protected ProfessorRepository getRepository() {
		return repository;
	}

}
