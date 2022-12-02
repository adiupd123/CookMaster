package com.adiupd123.cookmaster

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RecipeApi {

    @Headers(
        value = [
            "X-RapidAPI-Key: 3f6546ba6amshfe9f52338fcc72cp1037d0jsnbfbb9df165d3",
            "X-RapidAPI-Host: tasty.p.rapidapi.com"
        ]
    )
    @GET("/recipes/list?from=0&size=40&q={q}")
    fun getRecipes(@Path("q") q: String): Call<List<Recipe>>

}