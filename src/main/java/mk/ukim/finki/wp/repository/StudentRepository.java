package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByIndeks(String indeks);
	
	List<Student> findByImeLike(String ime);
}
