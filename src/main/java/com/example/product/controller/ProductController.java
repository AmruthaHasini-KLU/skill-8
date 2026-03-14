package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    @PostMapping
    public Product addProduct(@RequestBody Product p){
        return repo.save(p);
    }

    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> priceFilter(@RequestParam double min,
                                     @RequestParam double max){
        return repo.findByPriceBetween(min,max);
    }

    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return repo.sortByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price){
        return repo.expensiveProducts(price);
    }
}