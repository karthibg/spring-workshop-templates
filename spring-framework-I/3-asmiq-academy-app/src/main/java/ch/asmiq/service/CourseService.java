package ch.asmiq.service;

import java.math.BigDecimal;
import java.util.List;

import ch.asmiq.model.Course;

public class CourseService {

	public List<Course> getCourses() {
		return List.of(new Course("Java", 2, new BigDecimal(50)), new Course("Design Patterns", 3, new BigDecimal(60)),
				new Course("Testing", 1, new BigDecimal(40)));
	}

}
