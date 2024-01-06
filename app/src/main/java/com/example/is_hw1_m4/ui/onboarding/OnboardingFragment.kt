package com.example.is_hw1_m4.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.is_hw1_m4.data.local.Pref
import com.example.is_hw1_m4.databinding.FragmentOnboardingBinding
import com.example.is_hw1_m4.ui.onboarding.adapter.OnboardingAdapter


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    private val adapter = OnboardingAdapter(this::onClick)
    private  val  pref by lazy {
        Pref(requireContext())
    }

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

}