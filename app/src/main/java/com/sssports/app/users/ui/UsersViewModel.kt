package com.sssports.app.users.ui

import androidx.lifecycle.ViewModel
import com.sssports.app.di.CoroutineScropeIO
import com.sssports.app.users.data.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

/**
 * The ViewModel for [UsersFragment].
 */
class UsersViewModel @Inject constructor(private val repository: UsersRepository,
                                         @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {

    val legoSets by lazy {
        repository.observeRemotePagedUsers(ioCoroutineScope)
    }

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }
}
