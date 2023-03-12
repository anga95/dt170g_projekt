package se.miun.dt170g.chefapp;

import java.util.ArrayList;

public class Order {
    private int tableNr;

    private int priority;

    private String course;
    private ArrayList<String> starter;
    private ArrayList<String> mainCourse;
    private ArrayList<String> dessert;
    private boolean starterready;
    private boolean mainCourseready;
    private boolean dessertready;

    private boolean completed;

    public Order(int priority, int tableNr, ArrayList<String> starter, ArrayList<String> mainCourse, ArrayList<String> dessert, boolean
                 starterready, boolean mainCourseready, boolean dessertready){
        this.priority = priority;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }

    public String getCourse() {
        return course;
    }

    public void setOrderReady(boolean completed) {
        this.completed = completed;
    }
    public boolean OrderReady() {
        return completed;
    }

}