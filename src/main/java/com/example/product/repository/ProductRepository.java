package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> expensiveProducts(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> categoryProducts(@Param("category") String category);
}