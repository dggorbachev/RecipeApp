package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api

import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.toDomain
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.Recipe
import javax.inject.Inject

class RecipeRepoImpl
@Inject constructor(private val source: RecipeRemoteSource) : RecipeRepo {
    override suspend fun getRecipes(): List<Recipe> {
        return source.getRecipes().results.map {
            it.toDomain()
        }
    }
}