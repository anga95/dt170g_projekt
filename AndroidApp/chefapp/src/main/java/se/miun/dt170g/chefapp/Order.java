package se.miun.dt170g.chefapp;

import java.util.List;

public class Order {
    private int tableNr;

    private int priority;

    private String course;
    private List<String> starter;
    private List<String> mainCourse;
    private List<String> dessert;
    private boolean starterready;
    private boolean mainCourseready;
    private boolean dessertready;

    private boolean completed;

    public Order(int priority, int tableNr, List<String> starter, List<String> mainCourse, List<String> dessert, boolean
                 starterisready, boolean mainCourseisready, boolean dessertisready){
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
