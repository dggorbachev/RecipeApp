package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class IngredientInfoModel(
    @SerializedName("display_plural")
    val displayPlural: String? = "",
    @SerializedName("display_singular")
    val displaySingular: String? = ""
)