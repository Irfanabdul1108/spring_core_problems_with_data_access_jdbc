package com.example.demo.model;

public class ProductCategory {

    private String productName;
    private String categoryDescription;

    public ProductCategory() {
    }

    public ProductCategory(String productName, String categoryDescription) {
        this.productName = productName;
        this.categoryDescription = categoryDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}