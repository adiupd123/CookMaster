package com.adiupd123.cookmaster.models

import com.google.gson.annotations.SerializedName

class Measurement(
    @SerializedName("id")val id: Int,
    @SerializedName("quantity")val quantity: String,
    @SerializedName("unit")val unit: Unit
)