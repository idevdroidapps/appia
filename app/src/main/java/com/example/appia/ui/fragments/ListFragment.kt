package com.example.appia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appia.R
import com.example.appia.databinding.FragmentListBinding
import com.example.appia.ui.viewmodels.SharedViewModel

class ListFragment: Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val viewModel: SharedViewModel by activityViewModels()

    val binding: FragmentListBinding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
    return binding.root
  }
}