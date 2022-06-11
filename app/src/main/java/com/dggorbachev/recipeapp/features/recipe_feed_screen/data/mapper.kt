package com.dggorbachev.recipeapp.features.recipe_feed_screen.data

import android.util.Log
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.model.*
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.*

fun RecipeModel.toDomain() = Recipe(
    id = id,
    title = title,
    imageUrl = imageUrl,
    description = description,
    videoUrl = videoUrl,
    numServings = numServings,
    instruction = instructions?.map { it.toDomain() },
    userRatings = userRatings?.toDomain(),
    sections = sections?.map { it.toDomain() }
)

fun InstructionModel.toDomain() = Instruction(
    displayText = displayText,
    startTime = startTime,
    endTime = endTime
)

fun UserRatingsModel.toDomain() = UserRatings(
    score = score,
    countPositive = countPositive,
    countNegative = countNegative
)

fun SectionModel.toDomain() = Section(
    name = name,
    components = components.map { it.toDomain() }
)

fun ComponentModel.toDomain() = Component(
    displayPlural = ingredientInfo?.displayPlural,
    displaySingular = ingredientInfo?.displaySingular,
    measurements = measurements.map { it.toDomain() }
)

fun MeasurementsModel.toDomain() = Measurements(
    quantity = quantity.toNumber()
)

//¼½¾⅓⅔⅛
fun String.toNumber(): Double {
    var item = this.replace("\\s".toRegex(), "")
    item = item.replace("¼", ".25")
    item = item.replace("½", ".5")
    item = item.replace("¾", ".75")
    item = item.replace("⅓", ".33")
    item = item.replace("⅔", ".67")
    item = item.replace("⅛", ".125")

    val newItem = item.toDouble()
    Log.e("NUMBER", newItem.toString())
    return newItem
}