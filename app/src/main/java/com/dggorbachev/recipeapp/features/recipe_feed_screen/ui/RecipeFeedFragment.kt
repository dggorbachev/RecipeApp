package com.dggorbachev.recipeapp.features.recipe_feed_screen.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dggorbachev.recipeapp.R
import com.dggorbachev.recipeapp.databinding.FragmentRecipeFeedBinding
import com.dggorbachev.recipeapp.features.recipe_feed_screen.ui.adapter.RecipesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFeedFragment : Fragment(R.layout.fragment_recipe_feed) {

    private var _binding: FragmentRecipeFeedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RecipeFeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipesAdapter = RecipesAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvRecipes)
        recyclerView.adapter = recipesAdapter
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

        viewModel.viewState.observe(viewLifecycleOwner) {
            Log.e("BLYAD", it.recipeList.toString())
            binding.progressBar.isGone = !it.isLoading
            recipesAdapter.submitList(it.recipeList)
        }
    }
}