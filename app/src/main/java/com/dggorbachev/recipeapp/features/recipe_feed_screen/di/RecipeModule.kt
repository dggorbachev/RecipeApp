package com.dggorbachev.recipeapp.features.recipe_feed_screen.di

import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.RecipeApi
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.RecipeRemoteSource
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.RecipeRepo
import com.dggorbachev.recipeapp.features.recipe_feed_screen.data.api.RecipeRepoImpl
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.RecipeInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Provides
    @Singleton
    fun providesRecipeApi(retrofit: Retrofit): RecipeApi =
        retrofit.create(RecipeApi::class.java)

    @Provides
    @Singleton
    fun providesRecipeRemoteSource(api: RecipeApi): RecipeRemoteSource =
        RecipeRemoteSource(recipeApi = api)

    @Provides
    @Singleton
    fun providesRecipeRepo(source: RecipeRemoteSource): RecipeRepo =
        RecipeRepoImpl(source = source)

    @Provides
    @Singleton
    fun providesRecipeInteractor(recipeRepo: RecipeRepo): RecipeInteractor =
        RecipeInteractor(recipeRepo = recipeRepo)
}