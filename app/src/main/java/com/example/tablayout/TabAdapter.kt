package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(act: AppCompatActivity) : FragmentStateAdapter(act){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RegFragment()
            1 -> LogFragment()
            else -> throw IllegalArgumentException("Position out of array")
        }
    }
}