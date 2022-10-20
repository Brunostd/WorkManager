package com.deny.workmanager.model

import java.io.Serializable

data class MoviesModel(
    val id: Int?,
    var title: String,
    var year: String,
    var rated: String,
    var released: String,
    var runtime: String,
    var genre: String,
    var director: String,
    var writer: String,
    var actors: String,
    var plot: String,
    var poster: String
): Serializable {
}