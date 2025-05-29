package com.example.springEducation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TextBook implements Books {
    @Value("${textBook.num_of_pages}")
    private int num_of_pages;
    @Value("${textBook.price}")
    private float price;
    @Value("${textBook.title}")
    private String title;

    @Autowired
    public TextBook() {
    }

    public TextBook(int num_of_pages, float price, String title) {
        this.num_of_pages = num_of_pages;
        this.price = price;
        this.title = title;
    }

    @Override
    public double getWeight() {
        return this.num_of_pages * 0.004;
    }

    @Override
    public double estimatedPopularity() {
        return (float)Math.round((getWeight() * this.title.length())/price*1000.0)/1000.0;
    }

    public int getnum_of_pages() {
        return num_of_pages;
    }

    public void setnum_of_pages(int num_of_pages) {
        this.num_of_pages = num_of_pages;
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
        price = 800;
        System.out.println("Base price: 800");
    }

    @Override
    public void onDestroy(){
    System.out.println("Sales is over!");
    }
}
