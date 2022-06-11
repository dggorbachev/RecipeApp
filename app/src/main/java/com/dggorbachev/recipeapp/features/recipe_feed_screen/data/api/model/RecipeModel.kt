package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("thumbnail_url")
    val imageUrl: String,
    @SerializedName("video_url")
    val videoUrl: String? = "",
    @SerializedName("num_servings")
    val numServings: Int,
    @SerializedName("user_ratings")
    val userRatings: UserRatingsModel? = null,
    @SerializedName("instructions")
    val instructions: List<InstructionModel>? = emptyList(),
    @SerializedName("sections")
    val sections: List<SectionModel>? = emptyList()
)