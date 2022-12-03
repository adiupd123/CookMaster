package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class RecipeResponse(
    @JsonProperty("count") val count: Int,
    @JsonProperty("results") val results: List<Recipe>
)