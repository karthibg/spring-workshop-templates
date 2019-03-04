package ch.asmiq.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CourseService;
import ch.asmiq.model.Course;

@Primary
@Service
public class LiveCourseService implements CourseService {

	@Override
	public List<Course> getCourses() {
		return List.of(new Course("Java", 2, new BigDecimal(50)), new Course("Design Patterns", 3, new BigDecimal(60)),
				new Course("Testing", 1, new BigDecimal(40)));
	}

}
