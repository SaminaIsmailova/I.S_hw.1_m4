package com.example.is_hw1_m4.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.is_hw1_m4.App
import com.example.is_hw1_m4.R
import com.example.is_hw1_m4.databinding.FragmentTaskBinding
import com.example.is_hw1_m4.databinding.ItemTaskBinding
import com.example.is_hw1_m4.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        task = arguments?.getSerializable("key") as Task?
        binding.etTitle.setText(task?.title)
        binding.etDesc.setText(task?.desc)
        if (task!=null){
            binding.btnSave.text="update"
            binding.btnSave.setOnClickListener {
                update()
            }
        }else{
            binding.btnSave.setOnClickListener {
                save()
            }
        }
    }

    private fun save() = with(binding){
        var task = Task(
            title = etTitle.text.toString(),
            desc = etDesc.text.toString()
        )
        App.db.taskDao().insert(task)
        findNavController().navigateUp()
    }

    private fun update() = with(binding){
        var upDatetTask = task?.copy(
            title = etTitle.text.toString(),
            desc = etDesc.text.toString()
        )
        App.db.taskDao().update(upDatetTask!!)
        findNavController().navigateUp()
    }
}