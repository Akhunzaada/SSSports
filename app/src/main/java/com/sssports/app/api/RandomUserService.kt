package com.sssports.app.api

import com.sssports.app.users.data.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Lego REST API access points
 */
interface RandomUserService {

    companion object {
        const val ENDPOINT = "https://randomuser.me/"
    }

    @GET("api/")
    suspend fun getRandomUsers(@Query("page") page: Int? = null,
                               @Query("results") pageSize: Int? = null): Response<ResultsResponse<User>>

}
