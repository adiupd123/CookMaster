package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Measurement(
    @JsonProperty("id")val id: Int,
    @JsonProperty("quantity")val quantity: String?,
    @JsonProperty("unit")val unit: Unit?
)