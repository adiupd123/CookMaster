package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Section(
    @JsonProperty("components")val components: List<Component>?,
    @JsonProperty("name")val name: Any?,
    @JsonProperty("position") val position: Int?
)