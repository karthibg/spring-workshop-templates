package ch.asmiq.service;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.FeedbackService;
import ch.asmiq.model.Order;

@Service
public class SurveyMonkey implements FeedbackService{

	public void conductSurvey(Order order) {
		System.out.println("survey conducted");
	}
}
