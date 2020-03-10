package com.sssports.app.users.data

import com.sssports.app.api.BaseDataSource
import com.sssports.app.api.RandomUserService
import javax.inject.Inject

/**
 * Works with the Lego API to get data.
 */
class UsersRemoteDataSource @Inject constructor(private val service: RandomUserService) : BaseDataSource() {

    suspend fun fetchSets(page: Int, pageSize: Int? = null, themeId: Int? = null)
            = getResult { service.getRandomUsers(page, pageSize) }
}
