package com.example.shemajamebeli10.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli10.R
import com.example.shemajamebeli10.databinding.TopicRecyclerItemBinding
import com.example.shemajamebeli10.model.Course

class TopicRecyclerAdapter : RecyclerView.Adapter<TopicRecyclerAdapter.ViewHolder>() {

    private  var items = mutableListOf<Course.Topic>()

    inner class ViewHolder(val binding : TopicRecyclerItemBinding):RecyclerView.ViewHolder(binding.root){

        private lateinit var model:Course.Topic

        fun bind(){

            model = items[adapterPosition]

            if (model.type=="free"){
                binding.topicIcon.setImageResource(R.drawable.ic_small_cards_play)
            }else{
                binding.topicIcon.setImageResource(R.drawable.ic_settings)
            }

            binding.topicTitle.text = model.title
            binding.duration.text = model.duration.toString() + "min"
//            binding.root.setCardBackgroundColor(model.color)

            binding.playButton.setOnClickListener {


            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TopicRecyclerItemBinding.inflate(
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

    fun getData(items: List<Course.Topic>){

        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }
}