package ch.karthi.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class TemplateController {

	public String sayHello() {
		
		return "hi HBT";
	}

}
