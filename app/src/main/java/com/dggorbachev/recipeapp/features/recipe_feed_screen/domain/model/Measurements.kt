package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Measurements(
    val quantity: Double? = 0.0
) : Parcelable