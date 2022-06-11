package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Component(
    val displayPlural: String? = "",
    val displaySingular: String? = "",
    val measurements: List<Measurements>
) : Parcelable