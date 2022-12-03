package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Component(
    @JsonProperty("extra_comment")val extra_comment: String?,
    @JsonProperty("id")val id: Int,
    @JsonProperty("ingredient")val ingredient: Ingredient?,
    @JsonProperty("measurements")val measurements: List<Measurement>?,
    @JsonProperty("position")val position: Int?,
    @JsonProperty("raw_text")val raw_text: String?
)