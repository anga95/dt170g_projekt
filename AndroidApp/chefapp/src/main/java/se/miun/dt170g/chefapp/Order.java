package se.miun.dt170g.chefapp;

import java.util.ArrayList;

public class Order {
    private int tableNr;
    private String notes;
    private int quantity;
    private int time;

    private ArrayList<String> starter;
    private ArrayList<String> mainCourse;
    private ArrayList<String> dessert;
    private boolean starterready;
    private boolean mainCourseready;
    private boolean dessertready;

    private boolean completed;

    public Order( int tableNr, ArrayList<String> starter, ArrayList<String> mainCourse, ArrayList<String> dessert, boolean
                 starterready, boolean mainCourseready, boolean dessertready, String notes, int quantity, int time){

        this.tableNr = tableNr;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.starterready = false;
        this.mainCourseready = false;
        this.dessertready = false;
        this.notes = notes;
        this.quantity = quantity;
        this.time = time;
    }

    public void setTableNr(int tableNr){
        this.tableNr = tableNr;
    }

    public int getTableNr(){
        return tableNr;
    }


    public void setStarter(ArrayList<String> starter) {
        this.starter = starter;
    }

    public ArrayList<String> getStarter() {
        return new ArrayList<String>(starter);
    }

    public boolean starterReady() {
        return starterready;
    }

    public void setStarterready(boolean starterready) {
        this.starterready = starterready;
    }


    public void setMainCourse(ArrayList<String> mainCourse) {
        this.mainCourse = mainCourse;
    }
    public ArrayList<String> getMainCourse(){
        return mainCourse;
    }

    public boolean mainCourseReady() {
        return mainCourseready;
    }

    public void setMainCourseready(boolean mainCourseready) {
        this.mainCourseready = mainCourseready;
    }

    public void setDessert(ArrayList<String> dessert) {
        this.dessert = dessert;
    }
    public ArrayList<String> getDessert(){
        return dessert;
    }

    public boolean dessertReady() {
        return dessertready;
    }

    public void setDessertready(boolean dessertready) {
        this.dessertready = dessertready;
    }


    public void setOrderReady(boolean completed) {
        this.completed = completed;
    }
    public boolean OrderReady() {
        return completed;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}
