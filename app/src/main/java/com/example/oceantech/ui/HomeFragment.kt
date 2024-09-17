package com.example.oceantech.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.oceantech.R
import com.example.oceantech.databinding.FragmentHomeBinding
import com.example.oceantech.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        configTabLayout()
        initClicks()
    }

    private fun initClicks() {
        binding.iclogout.setOnClickListener { logoutApp() }
    }

    private fun logoutApp() {
        auth.signOut()
        findNavController().navigate(R.id.action_homeFragment_to_authentication)
    }

    private fun configTabLayout() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(TodoFragment(), "Fazer")
        adapter.addFragment(DoingFragment(), "Fazendo")
        adapter.addFragment(DoneFragment(), "Feito")

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab, position ->
            tab.text = adapter.getTitle(
                position
            )
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
