package com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class SectionModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("components")
    val components: List<ComponentModel>
)