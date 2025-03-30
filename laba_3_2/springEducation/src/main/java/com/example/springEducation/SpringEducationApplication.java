package com.example.springEducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringEducationApplication {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml"
	);
	public static void main(String[] args) {
		Books_show books_show = context.getBean("book_show", Books_show.class);
		books_show.show();

		context.close();
	}

}
