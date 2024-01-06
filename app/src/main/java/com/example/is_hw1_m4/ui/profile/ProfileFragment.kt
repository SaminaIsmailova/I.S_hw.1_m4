package com.example.is_hw1_m4.ui.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.is_hw1_m4.R
import com.example.is_hw1_m4.data.local.Pref
import com.example.is_hw1_m4.databinding.FragmentProfileBinding
import com.example.is_hw1_m4.utils.loadImage

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val pref by lazy {
        Pref(requireContext())
    }

    private val openGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val selectedImageUri = it.data?.data
                pref.saveImage(selectedImageUri.toString())
                binding.imgProfile.loadImage(selectedImageUri.toString())
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgProfile.loadImage(pref.getImage())
        binding.etName.setText(pref.getName())

        binding.imgProfile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            openGallery.launch(intent)
        }
        binding.btnSave.setOnClickListener {
            pref.saveName(binding.etName.text.toString())
        }
    }
}