package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Student;

public interface CrudStudentService extends BaseEntityCrudService<Student> {

	List<Student> findByIndeks(String indeks);

	List<Student> findByImeLike(String ime);
}
