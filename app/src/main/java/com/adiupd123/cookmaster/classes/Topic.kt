package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Topic(
    @JsonProperty("name") val name: String,
    @JsonProperty("slug")val slug: String
)