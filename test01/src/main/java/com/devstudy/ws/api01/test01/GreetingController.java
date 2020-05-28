package com.devstudy.ws.api01.test01;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/greetingMore")
	public Greeting greetingMore(@RequestParam(value = "name", defaultValue = "Who") String name) {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String msg = "";
		if(hour < 12) {
			msg = "Good morning, %s";
		} else {
			msg = "Good afternoon, %s";
		}
		return new Greeting(counter.incrementAndGet(), String.format(msg, name));
	}

}
