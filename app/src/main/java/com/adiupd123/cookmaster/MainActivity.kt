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
import com.adiupd123.cookmaster.classes.Recipe
import com.adiupd123.cookmaster.classes.RecipeResponse
import com.adiupd123.cookmaster.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


const val TAG = "MainActivity.kt"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = binding.button
        val userService = UserService()

        btn.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // make the req here//
                val userResponse = userService.userApi.getRecipes("/recipes/list?from=0&size=40&q=Paneer").execute()
                withContext (Dispatchers.Main) {
                    if(userResponse.isSuccessful && userResponse.body() !=  null){
                        Log.e("Checking Response", userResponse.body().toString())
                        var recipeResponse = userResponse.body()!!
                        var recipes = recipeResponse.results

                    } else{
                        Log.e(TAG, "Response not successful")
                    }
                }
            }
        }
    }

}
