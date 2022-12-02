package com.adiupd123.cookmaster

import com.fasterxml.jackson.annotation.JsonProperty

data class Recipe(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val recipeName: String,
    @JsonProperty("thumbnail_url") val thumbnailUrl: String,
    @JsonProperty("created_at")val createdAt: Int
)
