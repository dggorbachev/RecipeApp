package com.dggorbachev.recipeapp.features.recipe_feed_screen.ui

import com.dggorbachev.recipeapp.base.Event
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.Recipe

data class ViewState(
    val recipeList: List<Recipe>,
    val isLoading: Boolean
)

sealed class UiEvent : Event {

}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    object OnStartLoadData : DataEvent()
    data class SuccessRequest(val recipeList: List<Recipe>) : DataEvent()
    data class ErrorRequest(val message: String) : DataEvent()
}