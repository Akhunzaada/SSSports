package com.sssports.app.users.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations.
 */
@Singleton
class UsersRepository @Inject constructor(private val usersRemoteDataSource: UsersRemoteDataSource) {

    fun observeRemotePagedUsers(ioCoroutineScope: CoroutineScope): LiveData<PagedList<User>> {
        val dataSourceFactory = UsersPageDataSourceFactory(usersRemoteDataSource, ioCoroutineScope)
        return LivePagedListBuilder(dataSourceFactory, UsersPageDataSourceFactory.pagedListConfig()).build()
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: UsersRepository? = null

        fun getInstance(usersRemoteDataSource: UsersRemoteDataSource) =
                instance ?: synchronized(this) {
                    instance ?: UsersRepository(usersRemoteDataSource).also { instance = it }
                }
    }
}
