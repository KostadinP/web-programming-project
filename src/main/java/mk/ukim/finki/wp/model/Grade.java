package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="grades")
public class Grade extends BaseEntity{

	@NotNull
	private short vrednost;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Professor professor;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public short getVrednost() {
		return vrednost;
	}

	public void setVrednost(short vrednost) {
		this.vrednost = vrednost;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
