package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api

import com.dggorbachev.recipeapp.base.common.Constants.API_KEY
import com.dggorbachev.recipeapp.base.common.Constants.END_POINT_RANDOM_RECIPES
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model.RecipeResponseModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeApi {
    @Headers(
        "X-RapidAPI-Host: tasty.p.rapidapi.com",
        "X-RapidAPI-Key: $API_KEY"
    )
    @GET(END_POINT_RANDOM_RECIPES)
    suspend fun getRecipes(
        @Query("from") from: Int = 0,
        @Query("size") size: Int = 100,
        @Query("tags") tags: String = "under_30_minutes"
    ): RecipeResponseModel
}