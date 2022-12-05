package com.adiupd123.cookmaster.models

import com.google.gson.annotations.SerializedName

class Section(
    @SerializedName("components")val components: List<Component>,
    @SerializedName("name")val name: Any,
    @SerializedName("position") val position: Int
)