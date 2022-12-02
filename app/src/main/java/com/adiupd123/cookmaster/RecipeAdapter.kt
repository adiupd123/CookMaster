package com.adiupd123.cookmaster

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adiupd123.cookmaster.databinding.RecipeItemBinding
import com.bumptech.glide.Glide
import com.google.android.material.internal.ContextUtils.getActivity

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    inner class RecipeViewHolder(val binding: RecipeItemBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback  = object: DiffUtil.ItemCallback<Recipe>(){
        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var recipes: List<Recipe>
        get() = differ.currentList
        set(value) { differ.submitList(value) }



    override fun getItemCount(): Int = recipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(RecipeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.apply {
            val recipe = recipes[position]
            Glide.with(this.root)
                .load(recipe.thumbnailUrl)
                .centerCrop()
                .into(recipeImageView)
            recipeNameTextView.text = recipe.recipeName
            recipeCreatedDateTextView.text = recipe.createdAt.toString()
        }
    }

}