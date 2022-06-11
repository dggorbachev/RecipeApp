package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api

import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model.RecipeResponseModel
import javax.inject.Inject

class RecipeRemoteSource
@Inject constructor(private val recipeApi: RecipeApi) {
    suspend fun getRecipes(): RecipeResponseModel {
        return recipeApi.getRecipes()
    }
}