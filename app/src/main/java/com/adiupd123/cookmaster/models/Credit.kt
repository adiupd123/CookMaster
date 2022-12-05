package com.adiupd123.cookmaster.models

import com.google.gson.annotations.SerializedName


class Credit(
    @SerializedName("name")val name: String,
    @SerializedName("type")val type: String
)