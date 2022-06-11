package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class UserRatingsModel(
    @SerializedName("score")
    val score: Double? = 0.0,
    @SerializedName("count_positive")
    val countPositive: Int? = 0,
    @SerializedName("count_negative")
    val countNegative: Int? = 0,
)