package com.example.ordersystem;

public class SourceItem {
    private String foodName;
    private double price;
    private String category;
    private int idNum;

    private int time;

    public SourceItem(String name, double price, String category, int idNum, int time) {
        this.foodName = name;
        this.price = price;
        this.category = category;
        this.idNum = idNum;
        this.time = time;
    }

    public String getName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.foodName = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getTime() {
        return time;
    }
}
