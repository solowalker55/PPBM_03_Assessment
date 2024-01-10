package com.dioageng.thirdassignmentofppbm.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dioageng.thirdassignmentofppbm.fragments.FirstFragment
import com.dioageng.thirdassignmentofppbm.fragments.FourthFragment
import com.dioageng.thirdassignmentofppbm.fragments.SecondFragment
import com.dioageng.thirdassignmentofppbm.fragments.ThirdFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0->{
                FirstFragment()
            }
            1->{
                SecondFragment()
            }
            2->{
                ThirdFragment()
            }
            3->{
                FourthFragment()
            }
            else->
                Fragment()
        }
    }
}