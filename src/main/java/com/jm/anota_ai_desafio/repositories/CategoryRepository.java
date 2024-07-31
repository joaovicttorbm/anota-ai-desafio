package com.jm.anota_ai_desafio.repositories;

import com.jm.anota_ai_desafio.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String> {
    boolean existsByTitle(String title);
}
