package com.arash.altafi.hilt.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.arash.altafi.hilt.R
import kotlinx.android.synthetic.main.fragment_page3.*


class Page3 : Fragment() {

    // Create Instance From ViewModel For NavGraph
    // Added New NavGraph To ViewModel
    private val model : PageViewModel by hiltNavGraphViewModels(R.id.nav_2)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go To Fragment 4
        txt_page_3.setOnClickListener {
            findNavController().navigate(R.id.action_page3_to_page4)
        }

        // Insert New Value (From 0) because we add new NavGraph To ViewModel)
        // Use ViewModel And Insert New Value in counter (plus plus)
        view.setOnClickListener {
            Toast.makeText(requireContext() , "Counter :" + model.addCounter() , Toast.LENGTH_SHORT).show()
        }

    }

}