package com.junit.spring.junitspring;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloResource {
	@GetMapping
	public String Hello()
	{
		return "hello";
	}
	@GetMapping(value="/json" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Hello json() {
		return new Hello("12","manasa");
		
	}

}
