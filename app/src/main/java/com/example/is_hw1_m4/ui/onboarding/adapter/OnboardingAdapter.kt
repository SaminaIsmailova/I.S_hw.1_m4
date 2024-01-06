package com.example.is_hw1_m4.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.is_hw1_m4.databinding.ItemOnboardingBinding
import com.example.is_hw1_m4.model.OnBoarding
import com.example.is_hw1_m4.utils.loadImage

class OnboardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnboardingAdapter.OnboardingViewHolder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding(
            "Добро пожаловать в Task Manager!",
            "Удобный инструмент для управления задачами и повышения производительности.",
            "https://dspncdn.com/a1/media/originals/6f/f3/51/6ff35161e8ddf3b77a089c434953e83c.jpg"
        ),
        OnBoarding(
            "Основные возможности приложения",
            "Создавайте задачи и проекты.\n" +
                    "Устанавливайте сроки и приоритеты.\n" +
                    "Отмечайте задачи как выполненные.\n" +
                    "Просматривайте статистику производительности.",
            "https://www.playmeo.com/wp-content/uploads/2021/06/Planning-Board-for-sequencing-programs-shutterstock_615691754.png"
        ),
        OnBoarding(
            "Как вам поможет Task Manager?",
            "Увеличьте свою эффективность.\n" +
                    "Никогда не забудьте о важных задачах.\n" +
                    "Организуйте свои проекты более эффективно.",
            "https://www.pinclipart.com/picdir/big/409-4092024_get-started-for-free-clipart.png"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnboardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            binding.tvTitle.text = onBoarding.title.toString()
            binding.tvDesc.text = onBoarding.desc.toString()
            ivBoard.loadImage(onBoarding.image)
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnGetStarted.isVisible = adapterPosition == list.lastIndex


            btnGetStarted.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }
        }
    }
}