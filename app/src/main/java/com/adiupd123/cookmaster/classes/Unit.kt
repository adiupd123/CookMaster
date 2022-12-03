package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Unit(
    @JsonProperty("abbreviation")  val abbreviation: String?,
    @JsonProperty("display_plural")   val display_plural: String?,
    @JsonProperty("display_singular")  val display_singular: String?,
    @JsonProperty("name")   val name: String,
    @JsonProperty("system")   val system: String?
)