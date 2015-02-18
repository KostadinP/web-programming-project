package mk.ukim.finki.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.repository.CourseRepository;
import mk.ukim.finki.wp.service.CrudCourseService;

@Service
public class CrudCourseServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Course, CourseRepository> implements
		CrudCourseService {

	@Autowired
	private CourseRepository repository;
	
	@Override
	public List<Course> findByImeLike(String imePredmet) {
		return repository.findByImeLike(imePredmet);
	}

	@Override
	protected CourseRepository getRepository() {
		return repository;
	}

}
