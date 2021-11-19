package com.tihasg.rxjava.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ArticleResponse (
    @Json(name = "id")
    val id: Int?,

    @Json(name = "featured")
    val featured: Boolean?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "url")
    val url: String?,

    @Json(name = "imageUrl")
    val imageUrl: String?,

    @Json(name = "newsSite")
    val newsSite: String?,

    @Json(name = "summary")
    val summary: String?,

    @Json(name = "publishedAt")
    val publishedAt: String?,

    @Json(name = "launches")
    val launches: List<Launches>?,

    @Json(name = "events")
    val events: List<Events>?
)

@JsonClass(generateAdapter = true)
class Launches(
    @Json(name = "id")
    val id: String?,

    @Json(name = "provider")
    val provider: String?
    )

@JsonClass(generateAdapter = true)
class Events(
    @Json(name = "id")
    val id: String?,

    @Json(name = "provider")
    val provider: String?
)
