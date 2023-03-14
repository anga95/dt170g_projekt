package com.example.kitchenapp;

import java.util.ArrayList;

public class Order {
    private int tableNr;
    private ArrayList<String> starterNotes;
    private ArrayList<String> mainCourseNotes;
    private ArrayList<String> dessertNotes;
    private int time;
    private ArrayList<String> starterIDs;
    private ArrayList<String> mainCourseIDs;
    private ArrayList<String> dessertIDs;
    private ArrayList<String> starter;
    private ArrayList<String> mainCourse;
    private ArrayList<String> dessert;
    private ArrayList<String> starterQuantity;
    private ArrayList<String> mainCourseQuantity;
    private ArrayList<String> dessertQuantity;
    private boolean starterready;
    private boolean mainCourseready;
    private boolean dessertready;

    private boolean completed;

    public Order( int tableNr, ArrayList<String> starter, ArrayList<String> mainCourse, ArrayList<String> dessert, boolean
            starterready, boolean mainCourseready, boolean dessertready, ArrayList<String> notes, ArrayList<String> starterQuantity,
            int time, ArrayList<String> starterIDs, ArrayList<String> mainCourseIDs, ArrayList<String> dessertIDs,
            ArrayList<String> mainCourseQuantity, ArrayList<String> dessertQuantity, ArrayList<String> starterNotes,
            ArrayList<String> mainCourseNotes, ArrayList<String> dessertNotes){


        this.tableNr = tableNr;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.starterready = false;
        this.mainCourseready = false;
        this.dessertready = false;
        this.starterNotes = starterNotes;
        this.starterQuantity = starterQuantity;
        this.time = time;
        this.starterIDs = starterIDs;
        this.mainCourseIDs = mainCourseIDs;
        this.dessertIDs = dessertIDs;
        this.mainCourseQuantity = mainCourseQuantity;
        this.dessertQuantity = dessertQuantity;
        this.mainCourseNotes = mainCourseNotes;
        this.dessertNotes = dessertNotes;
    }

    public ArrayList<String> getStarterIDs() {
        return starterIDs;
    }

    public ArrayList<String> getMainCourseIDs() {
        return mainCourseIDs;
    }

    public ArrayList<String> getDessertIDs() {
        return dessertIDs;
    }

    public ArrayList<String> getStarterQuantity() {
        return starterQuantity;
    }

    public ArrayList<String> getMainCourseQuantity() {
        return mainCourseQuantity;
    }

    public ArrayList<String> getDessertQuantity() {
        return dessertQuantity;
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
        return starter;
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

    public ArrayList<String> getStarterNotes() {
        return starterNotes;
    }

    public ArrayList<String> getMainCourseNotes() {
        return mainCourseNotes;
    }

    public ArrayList<String> getDessertNotes() {
        return dessertNotes;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}