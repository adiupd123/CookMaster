package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Instruction(
    @JsonProperty("appliance")val appliance: Any,
    @JsonProperty("display_text")val display_text: String,
    @JsonProperty("end_time")val end_time: Int,
    @JsonProperty("id")val id: Int,
    @JsonProperty("position")val position: Int,
    @JsonProperty("start_time")val start_time: Int,
    @JsonProperty("temperature")val temperature: Any
)