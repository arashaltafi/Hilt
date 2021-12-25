package com.arash.altafi.hilt.di.modules

import com.arash.altafi.hilt.utils.PrefUser
import com.arash.altafi.hilt.utils.Users
import com.arash.altafi.hilt.utils.user
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// use @Module to create Module for add read only class to hilt (libraries or interface)
// use @InstallIn to set component for this class
// use @Binds to bind and add this class to Hilt (in bind method and class was has be abstract)
// use @Singleton When set component to SingleTonComponent

// priority for component is (SingleTon, ActivityRetainedScoped, ActivityScoped, FragmentScoped, ViewScoped, ServiceScoped, ViewModelScoped, ViewScoped)

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun provideName(prefUser: PrefUser) : user

    // OR Add With @Provides ==> in NetWorkModule
}