package com.example.springEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class BooksShow {


    private Books book;
    private String name;

    public Books getBook() {
        return book;
    }

    @Autowired
    public void setBook(@Qualifier("textBook") Books book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Qualifier("textBook")
    public void show(){
        System.out.println("Books{" +
                "weight='" + book.getWeight() +
                ", popularity='" + book.estimatedPopularity() +'\'' +
                '}');
    }
}
