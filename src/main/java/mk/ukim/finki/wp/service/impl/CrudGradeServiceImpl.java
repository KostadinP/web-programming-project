package mk.ukim.finki.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Grade;
import mk.ukim.finki.wp.repository.GradeRepository;
import mk.ukim.finki.wp.service.CrudGradeService;

@Service
public class CrudGradeServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Grade, GradeRepository> implements
		CrudGradeService {

	@Autowired
	private GradeRepository repository;
	
	@Override
	public List<Grade> findByStudentId(Long id) {
		return repository.findByStudentId(id);
	}

	@Override
	public List<Grade> findByCourseId(Long id) {
		return repository.findByCourseId(id);
	}

	@Override
	protected GradeRepository getRepository() {
		return repository;
	}

}
