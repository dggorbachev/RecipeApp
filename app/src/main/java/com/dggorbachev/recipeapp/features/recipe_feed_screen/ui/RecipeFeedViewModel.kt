package com.dggorbachev.recipeapp.features.recipe_feed_screen.ui

import android.util.Log
import com.dggorbachev.recipeapp.base.BaseViewModel
import com.dggorbachev.recipeapp.base.Event
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.RecipeInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeFeedViewModel
@Inject constructor(private val recipeInteractor: RecipeInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.OnLoadData)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            recipeList = emptyList(),
            isLoading = false
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                processDataEvent(DataEvent.OnStartLoadData)
                recipeInteractor.getRecipes().fold(
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorRequest(
                                it.message ?: "Unidentified error"
                            )
                        )
                    },
                    onSuccess = { processDataEvent(DataEvent.SuccessRequest(it)) }
                )
            }
            is DataEvent.OnStartLoadData -> {
                return previousState.copy(isLoading = true)
            }
            is DataEvent.SuccessRequest -> {
                return previousState.copy(recipeList = event.recipeList, isLoading = false)
            }
            is DataEvent.ErrorRequest -> {
                Log.e("BLYADSTVO", event.message)
                return previousState.copy(isLoading = true)
            }
        }
        return null
    }

}