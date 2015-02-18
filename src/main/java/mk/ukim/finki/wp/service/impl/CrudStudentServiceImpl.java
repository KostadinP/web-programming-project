package mk.ukim.finki.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.repository.StudentRepository;
import mk.ukim.finki.wp.service.CrudStudentService;

@Service
public class CrudStudentServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Student, StudentRepository> implements
		CrudStudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> findByIndeks(String indeks) {
		return repository.findByIndeks(indeks);
	}

	@Override
	public List<Student> findByImeLike(String ime) {
		return repository.findByImeLike(ime);
	}

	@Override
	protected StudentRepository getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
