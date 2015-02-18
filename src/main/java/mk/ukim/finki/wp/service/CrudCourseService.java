package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Course;

public interface CrudCourseService extends BaseEntityCrudService<Course>{

	List<Course> findByImeLike(String imePredmet);
}
