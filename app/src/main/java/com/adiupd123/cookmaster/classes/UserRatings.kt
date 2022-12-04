package com.adiupd123.cookmaster.classes

import com.google.gson.annotations.SerializedName

class UserRatings(
    @SerializedName("count_negative")   val count_negative: Int,
    @SerializedName("count_positive")    val count_positive: Int,
    @SerializedName("score")   val score: Double
)