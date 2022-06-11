package com.dggorbachev.recipeapp.features.recipe_feed_screen.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dggorbachev.recipeapp.R
import com.dggorbachev.recipeapp.databinding.ItemRecipeBinding
import com.dggorbachev.recipeapp.features.recipe_feed_screen.domain.model.Recipe
import java.lang.Exception

class RecipesAdapter() : ListAdapter<Recipe, RecipesAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            with(binding) {
                tvTitle.text = recipe.description.toString()
                Glide.with(binding.root)
                    .load(recipe.imageUrl)
                    .centerCrop()
                    .into(ivBackdrop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }

    class DiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }
}
