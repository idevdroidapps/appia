package com.example.appia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.appia.R
import com.example.appia.databinding.FragmentListBinding

class ListFragment: Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding: FragmentListBinding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
    return binding.root
  }
}