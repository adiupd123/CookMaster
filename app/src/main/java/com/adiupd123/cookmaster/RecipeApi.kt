package com.adiupd123.cookmaster

import com.adiupd123.cookmaster.models.RecipeResponse
import retrofit2.Call
import retrofit2.http.*

interface RecipeApi {

    @Headers(
        value = [
            "X-RapidAPI-Key: 3f6546ba6amshfe9f52338fcc72cp1037d0jsnbfbb9df165d3",
            "X-RapidAPI-Host: tasty.p.rapidapi.com"
        ]
    )
    @GET
    fun getRecipes(@Url url: String): Call<RecipeResponse>

}