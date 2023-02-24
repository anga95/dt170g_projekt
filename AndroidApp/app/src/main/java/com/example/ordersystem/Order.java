package com.example.ordersystem;

import java.util.List;

public class Order {
    private int tableNr;
    private List<String> starter;
    private List<String> mainCourse;
    private List<String> dessert;
    private boolean starterready;
    private boolean mainCourseready;
    private boolean dessertready;

    public Order(int tableNr, List<String> starter, List<String> mainCourse, List<String> dessert, boolean
                 starterisready, boolean mainCourseisready, boolean dessertisready){
        this.tableNr = tableNr;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.starterready = false;
        this.mainCourseready = false;
        this.dessertready = false;
    }

    public void setTableNr(int tableNr){
        this.tableNr = tableNr;
    }

    public int getTableNr(){
        return tableNr;
    }

    public List<String> getStarter() {
        return starter;
    }

    public boolean starterReady() {
        return starterready;
    }

    public void setStarterready(boolean starterready) {
        this.starterready = starterready;
    }

    public List<String> getMainCourse(){
        return mainCourse;
    }

    public boolean mainCourseReady() {
        return mainCourseready;
    }

    public void setMainCourseready(boolean mainCourseready) {
        this.mainCourseready = mainCourseready;
    }

    public List<String> getDessert(){
        return dessert;
    }

    public boolean dessertReady() {
        return dessertready;
    }

    public void setDessertready(boolean dessertready) {
        this.dessertready = dessertready;
    }

}
