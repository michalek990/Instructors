package com.example.instructors.Product;

import com.example.instructors.Entity.Keys.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
