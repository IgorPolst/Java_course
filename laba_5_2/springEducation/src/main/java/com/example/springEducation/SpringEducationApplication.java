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

		Books book = context.getBean("new_book_default", Books.class)
		Books_show default_book = new Books_show(book);
		default_book.show();


		Books_show books_show = context.getBean("book_show", Books_show.class);
		System.out.println(books_show);
		books_show.show();
		Books_show books_show2 = context.getBean("book_show", Books_show.class);
		books_show2.setName("Test");
		System.out.println(books_show2);

		context.close();
	}

}
