package com.dggorbachev.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dggorbachev.recipeapp.features.recipe_feed_screen.ui.RecipeFeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flMain, RecipeFeedFragment()).commit()
    }
}