package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Show(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name")  val name: String
)