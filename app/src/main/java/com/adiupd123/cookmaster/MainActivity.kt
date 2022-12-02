package com.adiupd123.cookmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.adiupd123.cookmaster.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.Path
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity.kt"

    private lateinit var binding: ActivityMainBinding

    private lateinit var recipeAdapter: RecipeAdapter

    private lateinit var searchedRecipe: String

    private lateinit var userResponse: Response<List<Recipe>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userService = UserService()
        searchedRecipe = binding.searchEditText.text.toString()
        setupRecyclerView()


        binding.searchButton.setOnClickListener {
            fun onClick(v: View): Unit {

                try{
                    userResponse = userService.userApi.getRecipes(searchedRecipe).execute()
                } catch(e: IOException){
                    Log.e(TAG, "IOException, you might not have internet connection")
                }catch (e: HttpException){
                    Log.e(TAG, "HttpException, unexpected response")
                }

                if(userResponse.isSuccessful && userResponse.body() !=  null){
                    recipeAdapter.recipes = userResponse.body()!!
                } else{
                    Log.e(TAG, "Response not successful")
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
