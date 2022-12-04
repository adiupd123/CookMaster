package com.adiupd123.cookmaster.classes

import com.google.gson.annotations.SerializedName


class RecipeResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<Recipe>
)