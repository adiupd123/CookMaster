package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Nutrition(
    @JsonProperty("calories")val calories: Int?,
    @JsonProperty("carbohydrates")val carbohydrates: Int?,
    @JsonProperty("fat")val fat: Int?,
    @JsonProperty("fiber")val fiber: Int?,
    @JsonProperty("protein")val protein: Int?,
    @JsonProperty("sugar")val sugar: Int?,
    @JsonProperty("updated_at")val updated_at: String?
)