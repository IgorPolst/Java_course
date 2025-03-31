package com.example.springEducation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringEducationApplication {
	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	public static void main(String[] args) {

		BooksShow booksShow = context.getBean(BooksShow.class);
		context.registerShutdownHook();
		booksShow.show();
	}
}
