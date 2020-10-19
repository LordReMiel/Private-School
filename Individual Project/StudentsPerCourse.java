
package privateschool.vol3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ReMieL
 */
public class StudentsPerCourse { 

	private Course course;

	private List<Student> students = new ArrayList<Student>();

	
	
	public StudentsPerCourse(Course course, List<Student> students) {
		this.course = course;
		this.students = students;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
    

