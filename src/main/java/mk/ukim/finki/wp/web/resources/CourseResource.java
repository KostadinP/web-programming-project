package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.service.CrudCourseService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data/rest/courses")
public class CourseResource extends CrudResource<Course, CrudCourseService>{

	@Autowired
	private CrudCourseService service;
	
	@Override
	public CrudCourseService getService() {
		return service;
	}

}
