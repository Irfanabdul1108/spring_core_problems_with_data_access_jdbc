package com.example.demo.runner;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.CategoryAverage;
import com.example.demo.model.ProductCategory;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private final ProductDao productDao;

    public MyRunner(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
public void run(String... args) {

    // Question 3

    Double average = productDao.getAveragePrice();

    System.out.println("Overall Average Price = " + average);

    System.out.println();

    // Question 4

    System.out.println("Category Wise Average Price");

    List<CategoryAverage> list =
            productDao.getCategoryWiseAveragePrice();

    for (CategoryAverage c : list) {

        System.out.println(
                "Category Code : "
                        + c.getCatCode()
                        + "    Average Price : "
                        + c.getAvgPrice()
        );

    }

    System.out.println();

    // Question 5

    System.out.println("Insert New Category");

    int rows = productDao.insertCategory(
            104,
            "Sports"
    );

    if (rows > 0) {

        System.out.println("Category Inserted Successfully");

    } else {

        System.out.println("Category Not Inserted");

    }
System.out.println();

System.out.println("Products having name less than 10 letters and price greater than 1000");

List<ProductCategory> products =
        productDao.getProducts(1000);

for(ProductCategory p : products){

    System.out.println(
            "Product Name : "
                    + p.getProductName()
                    + "    Category : "
                    + p.getCategoryDescription()
    );

}
}

}