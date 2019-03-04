package ch.asmiq.controller;

import java.util.List;

import ch.asmiq.model.Course;
import ch.asmiq.service.AsmiqAcademyService;

//TODO
public class CourseController {
	
	//TODO
	private AsmiqAcademyService asmiqAcademyService;

	//TODO
	public List<Course> courses(){
		return asmiqAcademyService.getCourses();
	}

}
