package com.adiupd123.cookmaster.models

import com.google.gson.annotations.SerializedName

class Nutrition(
    @SerializedName("calories")val calories: Int,
    @SerializedName("carbohydrates")val carbohydrates: Int,
    @SerializedName("fat")val fat: Int,
    @SerializedName("fiber")val fiber: Int,
    @SerializedName("protein")val protein: Int,
    @SerializedName("sugar")val sugar: Int,
    @SerializedName("updated_at")val updated_at: String
)