package com.sssports.app.users.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class UsersPageDataSourceFactory @Inject constructor(
        private val dataSource: UsersRemoteDataSource,
        private val scope: CoroutineScope) : DataSource.Factory<Int, User>() {

    private val liveData = MutableLiveData<UsersPageDataSource>()

    override fun create(): DataSource<Int, User> {
        val source = UsersPageDataSource(dataSource, scope)
        liveData.postValue(source)
        return source
    }

    companion object {
        private const val PAGE_SIZE = 10

        fun pagedListConfig() = PagedList.Config.Builder()
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setPageSize(PAGE_SIZE)
                .setEnablePlaceholders(true)
                .build()
    }
}