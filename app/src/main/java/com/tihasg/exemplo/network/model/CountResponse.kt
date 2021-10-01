package com.tihasg.exemplo.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CountResponse(
    @Json(name = "count")
    val count: Int?
)