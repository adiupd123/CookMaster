package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Credit(
    @JsonProperty("name")val name: String,
    @JsonProperty("type")val type: String
)