package com.example.shemajamebeli10

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli10.adapters.TopicRecyclerAdapter
import com.example.shemajamebeli10.databinding.ActivityMainBinding
import com.example.shemajamebeli10.databinding.TopicRecyclerItemBinding
import com.example.shemajamebeli10.network.Resource

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var topicAdapter : TopicRecyclerAdapter

    private val viewModel : CousresViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){

        viewModel.getCourse()
        initRecyclers()
        observes()
    }

    private fun initRecyclers(){
        topicAdapter = TopicRecyclerAdapter()
        binding.topicRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        binding.topicRecycler.adapter = topicAdapter


    }


    private fun observes() {
        viewModel._coursesLivedata.observe(this, {

            when (it.status) {

                Resource.Status.Succsess -> {
                    it.data?.topic?.let { it1 -> topicAdapter.getData(it1) }

                }
                Resource.Status.Error -> {

                }

            }

        })
    }


}