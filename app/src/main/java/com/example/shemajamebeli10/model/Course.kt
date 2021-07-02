package com.example.shemajamebeli10.model

data class Course(
    val courses: List<Courses>?,
    val topic: List<Topic>?
){
    data class Courses(
        val background_color_precent: String?,
        val color: String?,
        val image: String?,
        val precent: String?,
        val title: String?
        )

    data class Topic(
        val color: String?,
        val duration: Int?,
        val title: String?,
        val type: String?
    )
}