package com.example.ordersystem;

import java.util.List;

public class Order {
    private final int tableNumber;
    private final List<OrderItem> orderItemList;

    public Order(int tableNumber, List<OrderItem> orderItemList){
        this.tableNumber = tableNumber;
        this.orderItemList = orderItemList;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
