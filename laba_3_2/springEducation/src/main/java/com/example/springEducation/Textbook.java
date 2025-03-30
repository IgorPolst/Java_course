package com.example.springEducation;

public class Textbook implements Books {
    private int num_of_pages;
    private float price;
    private String title;

    public Textbook() {}

    public Textbook(int num_of_pages, float price, String title) {
        this.num_of_pages = num_of_pages;
        this.price = price;
        this.title = title;
    }

    @Override
    public double getWeight() {
        return this.num_of_pages * 0.004;
    }

    @Override
    public double estimated_popularity() {
        return (float)Math.round((getWeight() * this.title.length())/price*1000.0)/1000.0;
    }

    public int getNum_of_pages() {
        return num_of_pages;
    }

    public void setNum_of_pages(int num_of_pages) {
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
}
