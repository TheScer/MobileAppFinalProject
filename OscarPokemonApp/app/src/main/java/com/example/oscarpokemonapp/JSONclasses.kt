package com.example.oscarpokemonapp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class JSONclasses {
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Image {
    var sprites : defaults? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class defaults{
    var front_default : String? = null
    var front_shiny : String? = null
}
/*
@JsonIgnoreProperties(ignoreUnknown = true)
class others{
    var other : myother :
}
*/