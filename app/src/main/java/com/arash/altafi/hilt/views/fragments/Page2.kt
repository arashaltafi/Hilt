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
import kotlinx.android.synthetic.main.fragment_page2.*

class Page2 : Fragment() {

    // Create Instance From ViewModel For NavGraph
    private val model : PageViewModel by hiltNavGraphViewModels(R.id.nav_1)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go To NavGraph 2 (Fragment 3)
        txt_page_2.setOnClickListener {
            findNavController().setGraph(R.navigation.nav_2)
        }

        // Use ViewModel And Insert New Value in counter (plus plus)
        view.setOnClickListener {
            Toast.makeText(requireContext() , "Counter :" + model.addCounter() , Toast.LENGTH_SHORT).show()
        }
    }

}