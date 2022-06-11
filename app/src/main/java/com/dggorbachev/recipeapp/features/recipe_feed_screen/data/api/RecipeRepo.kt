package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api

import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.Recipe

interface RecipeRepo {
    suspend fun getRecipes(): List<Recipe>
}