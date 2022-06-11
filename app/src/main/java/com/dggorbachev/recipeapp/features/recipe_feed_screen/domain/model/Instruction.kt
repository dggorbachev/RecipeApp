package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Instruction(
    val displayText: String? = "",
    val startTime: Int? = 0,
    val endTime: Int? = 0
) : Parcelable
