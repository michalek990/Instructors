package com.example.instructors.Product;

import com.example.instructors.Entity.Keys.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product getProduct(String id);
    void deleteProduct(String id);
    Product updateProduct(String id, Product product);
    Iterable<Product> getAllProducts();
}
