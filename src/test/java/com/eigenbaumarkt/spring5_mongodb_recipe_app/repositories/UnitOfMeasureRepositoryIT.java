package com.eigenbaumarkt.spring5_mongodb_recipe_app.repositories;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.bootstrap.RecipeBootstrap;
import com.eigenbaumarkt.spring5_mongodb_recipe_app.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Before
    // we manually have to set up test environment for use with mongodb, exactly: the repositories,
    // which had been populated by Spring automatically with '@DataJpaTest'
    public void setUp() throws Exception {
        // because @Before runs on every test, there would be more than one unique value at the second (...) test
        // if we don't clean up the repositories before initializing them.
        // With DataJpa, we had transactions and a rollback after every test-method instead (default behaviour in Spring).
        recipeRepository.deleteAll();
        unitOfMeasureRepository.deleteAll();
        categoryRepository.deleteAll();


        // now fill the repositories with Bootstrap-data
        RecipeBootstrap recipeBootstrap = new RecipeBootstrap(categoryRepository, recipeRepository, unitOfMeasureRepository);
        recipeBootstrap.onApplicationEvent(null);
    }

    @Test
    public void findByDescription() throws Exception {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {

        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomOptional.get().getDescription());
    }

}
