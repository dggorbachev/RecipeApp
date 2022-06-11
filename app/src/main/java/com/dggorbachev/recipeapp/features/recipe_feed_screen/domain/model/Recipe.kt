package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val description: String? = "",
    val imageUrl: String,
    val videoUrl: String? = "",
    val numServings: Int,
    val instruction: List<Instruction>? = emptyList(),
    val userRatings: UserRatings? = null,
    val sections: List<Section>?= emptyList()
) : Parcelable