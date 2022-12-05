package com.adiupd123.cookmaster.models

import com.google.gson.annotations.SerializedName

class Topic(
    @SerializedName("name") val name: String,
    @SerializedName("slug")val slug: String
)