package com.adiupd123.cookmaster

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView.OnScrollListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adiupd123.cookmaster.classes.RecipeResponse
import com.adiupd123.cookmaster.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


const val TAG = "MainActivity.kt"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private var searchedRecipe: String? = ""
    private lateinit var userResponse: Response<RecipeResponse>
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        userService = UserService()

        searchedRecipe = binding.searchEditText.getText().toString()

        binding.button.setOnClickListener {
            binding.progressBar.isVisible = true
            GlobalScope.launch(Dispatchers.IO) {
                // make the req here//
                searchedRecipe = binding.searchEditText.getText().toString()
                userResponse = userService.userApi.getRecipes("/recipes/list?from=0&size=40&q=$searchedRecipe").execute()
                withContext (Dispatchers.Main) {
                    if(userResponse.isSuccessful && userResponse.body() !=  null){
                        Log.e("Checking Response", userResponse.body().toString())
                        var recipeResponse = userResponse.body()!!
                        recipeAdapter.recipes = recipeResponse.results
                    } else{
                        Log.e(TAG, "Response not successful")
                    }
                    binding.progressBar.isVisible = false
                }
            }
        }
    }
    fun setupRecyclerView() = binding.recipesRecyclerView.apply {
        recipeAdapter = RecipeAdapter()
        adapter = recipeAdapter
        layoutManager = GridLayoutManager(this@MainActivity, 2)
    }
}
