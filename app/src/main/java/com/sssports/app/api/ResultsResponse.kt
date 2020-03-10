package com.sssports.app.api

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T>(
    @SerializedName("results")
    val results: List<T>
)