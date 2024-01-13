package com.example.is_hw1_m4.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.is_hw1_m4.App
import com.example.is_hw1_m4.R
import com.example.is_hw1_m4.databinding.FragmentHomeBinding
import com.example.is_hw1_m4.model.Task
import com.example.is_hw1_m4.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = TaskAdapter(this::onClick, this::onLongClick)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        setData()
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    fun setData() {
        val data = App.db.taskDao().getAll()
        adapter.addTask(data)
    }

    private fun onClick(task: Task) {
        val bundle= bundleOf("key" to task)
        findNavController().navigate(R.id.taskFragment,bundle)
    }

    private fun onLongClick(task: Task) {
        val  builder = AlertDialog.Builder(requireContext())
        builder
            .setTitle("Delete")
            .setMessage("Are you sure you want to delete this task?")
            .setNegativeButton("No"){dialog,i->
                dialog.dismiss()
            }
            .setPositiveButton("Yes"){dialog,i->
                App.db.taskDao().delete(task)
                setData()
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}