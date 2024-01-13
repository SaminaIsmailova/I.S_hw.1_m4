package com.example.is_hw1_m4.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.is_hw1_m4.databinding.ItemTaskBinding
import com.example.is_hw1_m4.model.Task

class TaskAdapter(
    val onClick: (Task)->Unit,
    val onLongClick: (Task)->Unit,
) : Adapter<TaskAdapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>()

    fun addTask(task: List<Task>) {
        list.clear()
        list.addAll(task)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }
   inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.title.text = task.title
            binding.discription.text = task.desc

            itemView.setOnLongClickListener {
                onLongClick(task)
                true
            }
            itemView.setOnClickListener {
                onClick(task)
            }

            itemView.setBackgroundColor(if (adapterPosition % 2 == 0) Color.WHITE else Color.BLACK)
            binding.title.setTextColor(if (adapterPosition % 2 == 0) Color.BLACK else Color.WHITE)
            binding.discription.setTextColor(if (adapterPosition % 2 == 0) Color.BLACK else Color.WHITE)
        }
    }
}

