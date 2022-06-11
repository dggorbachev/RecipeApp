package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain

import com.dggorbachev.recipeapp.base.attempt
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.RecipeRepo
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.Recipe
import javax.inject.Inject

class RecipeInteractor
@Inject constructor(private val recipeRepo: RecipeRepo) {
    suspend fun getRecipes() = attempt {
        recipeRepo.getRecipes()
    }
}