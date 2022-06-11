package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class InstructionModel(
    @SerializedName("display_text")
    val displayText: String? = "",
    @SerializedName("start_time")
    val startTime: Int? = 0,
    @SerializedName("end_time")
    val endTime: Int? = 0
)