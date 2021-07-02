package com.example.shemajamebeli10.repository

import com.example.shemajamebeli10.model.Course
import com.example.shemajamebeli10.network.ApiService
import com.example.shemajamebeli10.network.Resource
import javax.inject.Inject

class CoursesRepositoryImplement @Inject constructor(val apiService: ApiService) : CoursesRepository {



    override suspend fun getCourses(): Resource<Course> {
        try {
            val response = apiService.getCourses()
            if (response.isSuccessful) {

                return Resource.succsess(response.body()!!)

            } else {

                return Resource.error(response.errorBody()!!.string())

            }
        } catch (e: Exception) {

            return Resource.error(e.message.toString())

        }
    }




}