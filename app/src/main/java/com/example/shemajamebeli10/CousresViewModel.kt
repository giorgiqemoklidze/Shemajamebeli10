package com.example.shemajamebeli10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli10.model.Course
import com.example.shemajamebeli10.network.Resource
import com.example.shemajamebeli10.repository.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CousresViewModel  @Inject constructor(val coursesRepository: CoursesRepository): ViewModel() {

    private var coursesLivedata = MutableLiveData<Resource<Course>>()

    var _coursesLivedata : LiveData<Resource<Course>> = coursesLivedata

    fun getCourse() {


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result =  coursesRepository.getCourses()
                coursesLivedata.postValue(result)
            }
        }

    }



}