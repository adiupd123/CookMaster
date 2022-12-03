package com.adiupd123.cookmaster

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.adiupd123.cookmaster.classes.RecipeResponse
import com.adiupd123.cookmaster.databinding.ActivityMainBinding
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


const val TAG = "MainActivity.kt"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        val userService = UserService()
        var searchedRecipe = binding.searchEditText.getText().toString()

        binding.searchButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                if (Build.VERSION.SDK_INT > 9) {
                    val policy = ThreadPolicy.Builder().permitAll().build()
                    StrictMode.setThreadPolicy(policy)

                    binding.progressBar.isVisible = true
                    Toast.makeText(applicationContext, "Button is clicked", Toast.LENGTH_SHORT).show()

                    val userResponse = userService.userApi.getRecipes("/recipes/list?from=0&size=40&q=${searchedRecipe}").execute()
                    try{

                    } catch(e: IOException){
                        Log.e(TAG, "IOException, you might not have internet connection")
                        binding.progressBar.isVisible = false
                    }catch (e: HttpException){
                        Log.e(TAG, "HttpException, unexpected response")
                        binding.progressBar.isVisible = false
                    }

                    if(userResponse.isSuccessful && userResponse.body() !=  null){
                        Log.e("Checking Response", userResponse.body().toString())
//                        var recipeResponse = userResponse.body()!!
//                        recipeAdapter.recipes = recipeResponse.results
                    } else{
                        Log.e(TAG, "Response not successful")
                    }
                }

            }
        })
    }

    fun setupRecyclerView() = binding.recipesRecyclerView.apply {
        recipeAdapter = RecipeAdapter()
        adapter = recipeAdapter
        layoutManager = GridLayoutManager(this@MainActivity, 2)
    }
}
