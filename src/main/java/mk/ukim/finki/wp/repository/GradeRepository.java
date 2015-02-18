package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.Grade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

	List<Grade> findByStudentId(Long id);

	List<Grade> findByCourseId(Long id);

}
