package com.example.shemajamebeli10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli10.databinding.CourcesRecyclerItemBinding import com.example.shemajamebeli10.databinding.TopicRecyclerItemBinding
import com.example.shemajamebeli10.model.Course

class CoursesRecyclerAdapter () : RecyclerView.Adapter <CoursesRecyclerAdapter.ViewHolder>() {

    private var items = mutableListOf<Course.Courses>()

    inner class ViewHolder(val binding : CourcesRecyclerItemBinding):RecyclerView.ViewHolder(binding.root){

        private lateinit var model:Course.Courses

        fun bind(){
            model = items[adapterPosition]
            binding.title.text = model.title
            binding.title2.text = model.title
            Glide.with(binding.image.context).load(model.image)
                .into(binding.image)


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CourcesRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind()
    }

    override fun getItemCount() = items.size

    fun getData(items:List<Course.Courses>){

        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }

}