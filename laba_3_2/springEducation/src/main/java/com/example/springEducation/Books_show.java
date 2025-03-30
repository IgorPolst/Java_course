package com.example.springEducation;

public class Books_show {
    private Books book;
    private String name;

    public Books_show(Books book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Books_show{" +
                "book=" + book.getClass() +
                ", name='" + this.name + '\'' +
                '}';
    }

    public void show(){
        System.out.println("Textbook{" +
                "weight='" + book.getWeight() +
                ", popularity='" + book.estimated_popularity() +'\'' +
                '}');
    }
}
