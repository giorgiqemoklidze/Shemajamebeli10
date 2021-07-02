package com.example.shemajamebeli10.di

import com.example.shemajamebeli10.network.ApiService
import com.example.shemajamebeli10.repository.CoursesRepository
import com.example.shemajamebeli10.repository.CoursesRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    companion object{

        const val BASE_URL = "https://run.mocky.io/v3/"

    }


    @Provides
    @Singleton
    fun getCourses() =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepostory(apiService: ApiService):CoursesRepository = CoursesRepositoryImplement(apiService)

}