package com.service.product.controller;

import com.service.product.entity.Product;
import com.service.product.exception.ProductExistsException;
import com.service.product.exception.ProductNotFoundException;
import com.service.product.repository.ProductRepo;
import com.service.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductApiImp {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${spring.profiles.active}")
    private String server;

    @Autowired
    private ProductService service;

    @Autowired
    ProductRepo repo;

    @GetMapping("/product")
    public List<String> productDeatils() {
        log.info("productDeatils Method starts");
        return Arrays.asList("product1", "product2", server);

    }

    @Override
    public ResponseEntity<Optional<Product>> findById(long id, String productAuthorization) throws Exception {
        log.info("findById Method starts");
        Optional<Product> product = Optional.ofNullable(service.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for this id " + id)));
        return ResponseEntity.ok().body(product);
    }

    @Override
    public Object insertProduct(Product product, String productAuthorization) throws Exception {
        log.info("insertProduct Method starts");
        return !repo.findById(product.getId()).isPresent() ?
         new ResponseEntity<Product>(service.save(product), HttpStatus.CREATED) :
                repo.findById(product.getId()).orElseThrow(
                        () -> new ProductExistsException("Product aready exists with id "+ product.getId())
                );

    }
}