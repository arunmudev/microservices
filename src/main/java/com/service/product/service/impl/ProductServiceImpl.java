package com.service.product.service.impl;

import com.service.product.entity.Product;
import com.service.product.exception.ProductNotFoundException;
import com.service.product.feign.OrderClient;
import com.service.product.repository.ProductRepo;
import com.service.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    OrderClient orderClient;
    Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductRepo repo;
    @Cacheable(cacheNames = "testcache")
    @Override
    public Optional<Product> findById(long id) {
        log.info("Data fetches from db");
        return repo.findById(id);
    }

    @Override
    @Transactional(rollbackOn = ProductNotFoundException.class,dontRollbackOn = ProductNotFoundException.class)
    public Product save(Product product) {
        long id = repo.save(product).getId();
//        if(id > 2){
//            throw new RuntimeException("Roll back!");
//        }
    //    orderClient.getData("a");
      log.info("data saved successfully "+id);
        return product;
    }
}
