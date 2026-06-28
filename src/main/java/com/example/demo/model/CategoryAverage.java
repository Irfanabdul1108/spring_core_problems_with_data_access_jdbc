package com.example.demo.model;

public class CategoryAverage {

    private int catCode;
    private double avgPrice;

    public CategoryAverage() {
    }

    public CategoryAverage(int catCode, double avgPrice) {
        this.catCode = catCode;
        this.avgPrice = avgPrice;
    }

    public int getCatCode() {
        return catCode;
    }

    public void setCatCode(int catCode) {
        this.catCode = catCode;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

}