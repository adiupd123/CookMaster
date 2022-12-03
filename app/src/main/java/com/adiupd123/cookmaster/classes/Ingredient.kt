package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Ingredient(
    @JsonProperty("created_at")val created_at: Int,
    @JsonProperty("display_plural")val display_plural: String,
    @JsonProperty("display_singular")val display_singular: String,
    @JsonProperty("id")val id: Int,
    @JsonProperty("name")val name: String,
    @JsonProperty("updated_at")val updated_at: Int
)