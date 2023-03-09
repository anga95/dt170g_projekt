package com.example.ordersystem;

public class OrderItem {
    private String name;
    private int quantity;
    private double price;
    private String note;
    private String category;

    public OrderItem(String name, int quantity, double price, String note, String category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
