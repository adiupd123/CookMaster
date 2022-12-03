package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Price(
    @JsonProperty("consumption_portion")val consumption_portion: Int,
    @JsonProperty("consumption_total")val consumption_total: Int,
    @JsonProperty("portion")val portion: Int,
    @JsonProperty("total")val total: Int,
    @JsonProperty("updated_at")val updated_at: String
)