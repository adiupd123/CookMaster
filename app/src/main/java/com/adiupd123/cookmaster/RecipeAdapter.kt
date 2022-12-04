package com.adiupd123.cookmaster

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adiupd123.cookmaster.classes.Recipe
import com.adiupd123.cookmaster.databinding.RecipeItemBinding
import com.bumptech.glide.Glide
import com.google.android.material.internal.ContextUtils.getActivity
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    inner class RecipeViewHolder(val binding: RecipeItemBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback  = object: DiffUtil.ItemCallback<Recipe>(){
        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.equals(newItem)
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
                .load(recipe.thumbnail_url)
                .centerCrop()
                .into(recipeImageView)
            recipeNameTextView.text = recipe.name
            val stamp = Timestamp(recipe.created_at.toLong())
            val date = Date(stamp.time)
            val sdf = SimpleDateFormat("dd-MM-yyyy")
            sdf.timeZone = TimeZone.getDefault()
            val formattedDate = sdf.format(date)
            recipeCreatedDateTextView.text = formattedDate
        }
    }

}