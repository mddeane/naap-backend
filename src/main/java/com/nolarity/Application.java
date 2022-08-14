package com.nolarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	public ModelAndView home()
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index"); // our index.html page will be rendered at http://localhost:5000/api 
	    return modelAndView;			   // we'll see index.html
	}
}
