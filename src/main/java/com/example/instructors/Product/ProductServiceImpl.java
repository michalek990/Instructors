package com.example.instructors.Product;

import com.example.instructors.Entity.Product;
import com.example.instructors.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product getProduct(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public void deleteProduct(String id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Product updateProduct(String id, Product product) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());

        return productRepository.save(productToUpdate);
    }

    @Override
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
