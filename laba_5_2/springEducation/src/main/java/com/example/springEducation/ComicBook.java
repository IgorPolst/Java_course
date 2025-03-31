package com.example.springEducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComicBook implements Books{
//    @Value("${comicBook.numOfPages}")
    private int numOfPages;
//    @Value("${comicBook.price}")
    private float price;
//    @Value("${comicBook.title}")
    private String title;
//    @Value("${comicBook.author}")
    private String author;


    public ComicBook() {
        price = 1000;
        numOfPages = 4;
        title = "default";
        author = "empty";
    }

    public ComicBook(int numOfPages, float price, String title, String author) {
        this.numOfPages = numOfPages;
        this.price = price;
        this.title = title;
        this.author = author;
    }

    @Override
    public double getWeight() {
        return this.numOfPages * 0.005;
    }

    @Override
    public double estimatedPopularity() {
        return (float)Math.round((getWeight() * (this.title.length() + this.author.length()))/price*1000.0)/1000.0;
    }

    public int getNumOfPages() {

        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {

        this.numOfPages = numOfPages;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float price) {

        this.price = price;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public void onInit(){
        price = 1000;
        System.out.println("Base price: 1000");
    }

    @Override
    public void onDestroy(){
        System.out.println("Sales is over!");
    }

}
