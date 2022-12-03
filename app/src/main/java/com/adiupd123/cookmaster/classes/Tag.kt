package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Tag(
    @JsonProperty("display_name") val display_name: String,
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("type")  val type: String
)