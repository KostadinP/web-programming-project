package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Grade;

public interface CrudGradeService extends BaseEntityCrudService<Grade> {

	List<Grade> findByStudentId(Long id);

	List<Grade> findByCourseId(Long id);

}
