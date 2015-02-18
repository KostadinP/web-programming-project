package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByImeLike(String imePredmet);
}
