package com.eigenbaumarkt.spring5_mongodb_recipe_app.repositories;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// CrudRepository can also be used for spring-boot-starter-data-mongodb !
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
