package com.example.oceantech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oceantech.R
import com.example.oceantech.databinding.FragmentFormTaskBinding

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
        val description = binding.edtDescription.text.toString().trim()

        if (description.isNotEmpty()) {

        } else {

        }
    }

    fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}}