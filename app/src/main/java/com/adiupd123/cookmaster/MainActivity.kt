package com.adiupd123.cookmaster

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adiupd123.cookmaster.models.RecipeResponse
import com.adiupd123.cookmaster.databinding.ActivityMainBinding
import com.adiupd123.cookmaster.models.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response


const val TAG = "MainActivity.kt"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recipesRecyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private var searchedRecipe: String? = ""
    private lateinit var userResponse: Response<RecipeResponse>
    private lateinit var userService: UserService
    private var recipeResponse: RecipeResponse = RecipeResponse(0, emptyList<Recipe>())

    private var isLoading: Boolean = false
    private lateinit var recipeLayoutManager: GridLayoutManager
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipesRecyclerView = binding.recipesRecyclerView
        handler = Handler()
        userService = UserService()

        searchedRecipe = binding.searchEditText.getText().toString()

        setupRecyclerView()

        binding.button.setOnClickListener {
            binding.appHeadTextView.isVisible = false
            loadData( isInitLoad = true)
        }
    }
    fun setupRecyclerView() {
        recipeAdapter = RecipeAdapter()
        recipesRecyclerView.adapter = recipeAdapter
        recipeLayoutManager = GridLayoutManager(this@MainActivity,2)
        recipesRecyclerView.layoutManager = recipeLayoutManager
        recipesRecyclerView.itemAnimator = DefaultItemAnimator()

        recipesRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(!isLoading){
                    if(recipeLayoutManager.findLastCompletelyVisibleItemPosition() == recipeResponse.results.size - 1 ){
                        loadData()
                        isLoading = true
                    }
                }
            }
        })

        recipeAdapter.registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver(){
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                recipeLayoutManager.scrollToPositionWithOffset(positionStart, 0)
            }
        })


    }

    private fun loadData(isInitLoad: Boolean = false) {
        binding.progressBar.isVisible = true
        if(isInitLoad){
            // Load initial data
            GlobalScope.launch(Dispatchers.IO) {
                // make the req here//
                searchedRecipe = binding.searchEditText.getText().toString()
                try{
                    userResponse =
                        userService.userApi.getRecipes("/recipes/list?from=0&size=5&q=$searchedRecipe")
                            .execute()
                } catch(e: IOException){
                    Log.e(TAG, "IOException, you might not have internet connection")
                    binding.progressBar.isVisible = false
                }catch (e: HttpException){
                    Log.e(TAG, "HttpException, unexpected response")
                    binding.progressBar.isVisible = false
                }
                withContext (Dispatchers.Main) {
                    if(userResponse.isSuccessful && userResponse.body() !=  null){
                        Log.e("Checking Response", userResponse.body().toString())
                        recipeResponse = userResponse.body()!!
                        recipeAdapter.recipes = recipeResponse.results
                    } else{
                        Log.e(TAG, "Response not successful")
                    }
                    binding.progressBar.isVisible = false
                }
            }
        }
        else{
            handler.postDelayed(Runnable {
                // load more data
                GlobalScope.launch(Dispatchers.IO) {
                    // make the req here//
                    var start: Int = recipeResponse.results.size
                    var end: Int = start + 5
                    try{
                        userResponse =
                            userService.userApi.getRecipes("/recipes/list?from=$start&size=$end&q=$searchedRecipe")
                                .execute()
                    } catch(e: IOException){
                        Log.e(TAG, "IOException, you might not have internet connection")
                        binding.progressBar.isVisible = false
                    }catch (e: HttpException){
                        Log.e(TAG, "HttpException, unexpected response")
                        binding.progressBar.isVisible = false
                    }
                    withContext(Dispatchers.Main) {
                        if (userResponse.isSuccessful && userResponse.body() != null) {
                            Log.e("Checking Response", userResponse.body().toString())
                            var newRecipeResponse = userResponse.body()!!
                            updateDataList(newRecipeResponse.results)
                        } else {
                            Log.e(TAG, "Response not successful")
                        }
                        isLoading = false
                        binding.progressBar.isVisible = false
                    }
                }
            }, 0)
        }
    }

    private fun updateDataList(newRecipes: List<Recipe>){
        val tempList = recipeResponse.results.toMutableList()
        tempList.addAll(newRecipes)
        recipeAdapter.recipes = tempList
        recipeResponse.results = tempList
    }
}
