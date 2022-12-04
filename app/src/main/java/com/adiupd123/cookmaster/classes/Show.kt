package com.adiupd123.cookmaster.classes

import com.google.gson.annotations.SerializedName

class Show(
    @SerializedName("id") val id: Int,
    @SerializedName("name")  val name: String
)