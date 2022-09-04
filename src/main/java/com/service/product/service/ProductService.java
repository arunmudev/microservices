package com.service.product.service;

import com.service.product.entity.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(long id);

    Product save(Product product);
}
