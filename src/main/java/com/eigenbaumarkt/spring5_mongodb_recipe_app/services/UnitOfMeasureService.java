package com.eigenbaumarkt.spring5_mongodb_recipe_app.services;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
