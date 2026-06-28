package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.CategoryAverage;
import com.example.demo.model.ProductCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Double getAveragePrice() {

        String sql = "SELECT AVG(price) FROM Product";

        return jdbcTemplate.queryForObject(
                sql,
                Double.class
        );

    }
    public List<CategoryAverage> getCategoryWiseAveragePrice() {

    String sql = """
            SELECT cat_code,
                   AVG(price) AS avgprice
            FROM Product
            GROUP BY cat_code
            """;

    return jdbcTemplate.query(sql, (rs, rowNum) -> {

        CategoryAverage categoryAverage = new CategoryAverage();

        categoryAverage.setCatCode(rs.getInt("cat_code"));

        categoryAverage.setAvgPrice(rs.getDouble("avgprice"));

        return categoryAverage;

    });

}
public int insertCategory(int catCode, String catDesc) {

    String sql = """
            INSERT INTO Category(cat_code, cat_desc)
            VALUES(?, ?)
            """;

    return jdbcTemplate.update(
            sql,
            catCode,
            catDesc
    );

}

public List<ProductCategory> getProducts(double price) {

    String sql = """
            SELECT
                p.pro_name,
                c.cat_desc
            FROM Product p
            JOIN Category c
            ON p.cat_code = c.cat_code
            WHERE LEN(p.pro_name) < 10
            AND p.price > ?
            """;

    return jdbcTemplate.query(

            sql,

            (rs, rowNum) -> {

                ProductCategory pc =
                        new ProductCategory();

                pc.setProductName(
                        rs.getString("pro_name"));

                pc.setCategoryDescription(
                        rs.getString("cat_desc"));

                return pc;

            },

            price

    );

}
}