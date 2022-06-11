package com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(
    val name: String? = "",
    val components: List<Component>
) : Parcelable