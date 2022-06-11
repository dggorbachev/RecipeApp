package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ComponentModel(
    @SerializedName("ingredient")
    val ingredientInfo: IngredientInfoModel? = null,
    @SerializedName("measurements")
    val measurements: List<MeasurementsModel>
)