package com.abdo.theshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.abdo.theshoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater,R.layout.fragment_instructions,container,false
        )
        // navigate to shoeListFragment
        binding.btnClick2.setOnClickListener {view->
            view.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListenFragment())
        }


        return binding.root
    }

}