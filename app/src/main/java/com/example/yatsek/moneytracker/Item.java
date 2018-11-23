package com.example.yatsek.moneytracker;

public class Item {

    private final int price;
    private final String title;
    private String comment;

    public Item(String title, int price) {
        this.price = price;
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }
}
