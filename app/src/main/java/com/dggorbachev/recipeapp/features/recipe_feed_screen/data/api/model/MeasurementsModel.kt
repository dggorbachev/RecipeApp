package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class MeasurementsModel(
    @SerializedName("quantity")
    val quantity: String
)
