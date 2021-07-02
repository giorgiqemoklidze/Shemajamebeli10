package com.example.shemajamebeli10.network

import com.example.shemajamebeli10.model.Course
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("29db8caa-95cb-44be-aa3c-eee0aa406870?fbclid=IwAR0LLc2-N-8_FhyAU-zgfffdkold4Uj2C9BWGrnElar0k1o8GHWKKzyLM9w")
    suspend fun getCourses(): Response<Course>

}