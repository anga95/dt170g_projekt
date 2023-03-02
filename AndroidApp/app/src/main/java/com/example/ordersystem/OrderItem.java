package com.example.ordersystem;

public class OrderItem {
    private String name;
    private int quantity;
    private double price;
    private String note;

    public OrderItem(String name, int quantity, double price, String note) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
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
}
