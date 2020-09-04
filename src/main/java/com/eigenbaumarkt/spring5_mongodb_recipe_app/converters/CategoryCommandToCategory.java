package com.eigenbaumarkt.spring5_mongodb_recipe_app.converters;


import com.eigenbaumarkt.spring5_mongodb_recipe_app.commands.CategoryCommand;
import com.eigenbaumarkt.spring5_mongodb_recipe_app.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(String.valueOf(source.getId()));
        category.setDescription(source.getDescription());
        return category;
    }
}