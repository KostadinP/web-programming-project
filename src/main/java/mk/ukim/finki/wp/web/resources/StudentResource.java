package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.service.CrudStudentService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/data/rest/students")
public class StudentResource extends CrudResource<Student, CrudStudentService>{
	
	@Autowired
	private CrudStudentService service;

	@Override
	public CrudStudentService getService() {
		return service;
	}

}
