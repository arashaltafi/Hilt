package com.arash.altafi.hilt.di.modules

import com.arash.altafi.hilt.di.qualifiers.ArashRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// use @Module to create Module for add read only class to hilt (libraries or interface)
// use @InstallIn to set component for this class
// use @Provides to provide and add this class to Hilt
// use @Singleton When set component to SingleTonComponent

// priority for component is (SingleTon, ActivityRetainedScoped, ActivityScoped, FragmentScoped, ViewScoped, ServiceScoped, ViewModelScoped, ViewScoped)

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://www.google.com")
            .build()
    }

    @Singleton
    @Provides
    @ArashRetrofit
    fun provideRetrofit2(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://www.arashaltafi.ir")
            .build()
    }


    // Sample add class in provides was binds

//    @Provides
//    fun provideName(@ApplicationContext context : Context) : user {
//        return PrefUser(context)
//    }

}