package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class UserRatings(
    @JsonProperty("count_negative")   val count_negative: Int?,
    @JsonProperty("count_positive")    val count_positive: Int?,
    @JsonProperty("score")   val score: Int?
)