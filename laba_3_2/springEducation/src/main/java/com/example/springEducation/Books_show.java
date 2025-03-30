package com.example.springEducation;

public class Books_show {
    private Books book;

    public Books_show(Books book) {
        this.book = book;
    }

    public void show(){
        System.out.println("Textbook{" +
                "weight='" + book.getWeight() +
                ", popularity='" + book.estimated_popularity() +'\'' +
                '}');
    }
}
