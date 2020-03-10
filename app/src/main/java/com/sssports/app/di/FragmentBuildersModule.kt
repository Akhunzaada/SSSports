package com.sssports.app.di

import com.sssports.app.users.ui.UserDetailFragment
import com.sssports.app.users.ui.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeLegoSetsFragment(): UsersFragment

    @ContributesAndroidInjector
    abstract fun contributeLegoSetFragment(): UserDetailFragment
}
