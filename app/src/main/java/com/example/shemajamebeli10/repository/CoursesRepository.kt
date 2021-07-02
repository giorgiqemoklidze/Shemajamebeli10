package com.example.shemajamebeli10.repository

import com.example.shemajamebeli10.model.Course
import com.example.shemajamebeli10.network.Resource

interface CoursesRepository {

    suspend fun getCourses(): Resource<Course>

}