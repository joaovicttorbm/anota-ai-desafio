package com.jm.anota_ai_desafio.repositories;

import com.jm.anota_ai_desafio.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByTitle(String title);
//    List<Product> findByTitle(String title);
//    List<Product> findByDescriptionContaining(String description);
//    List<Product> findByCategoryId(String categoryId);
//    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
//
//    @Query("{ 'title': ?0, 'price': { $gte: ?1, $lte: ?2 } }")
//    List<Product> findByTitleAndPriceBetween(String title, Integer minPrice, Integer maxPrice);
//
//    Page<Product> findByTitle(String title, Pageable pageable);
}

