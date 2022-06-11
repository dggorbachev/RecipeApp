package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRatings(
    val score: Double? = 0.0,
    val countPositive: Int? = 0,
    val countNegative: Int? = 0,
) : Parcelable
