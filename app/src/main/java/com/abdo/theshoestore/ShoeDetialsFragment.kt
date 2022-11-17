package com.abdo.theshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abdo.theshoestore.databinding.FragmentShoeDetialsBinding


class ShoeDetialsFragment : Fragment() {

    private lateinit var viewModel : ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetialsBinding>(
            inflater,R.layout.fragment_shoe_detials,container,false
        )
        // initialize viewModel
        viewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        binding.viewModel = viewModel
        binding.shoe = Shoe("","","","")

        // observe when addSuccessEvent to true and back to shoeListFragment
        viewModel.addSuccessEvent.observe(this.viewLifecycleOwner, Observer {isSuccess->
            if (isSuccess){
            findNavController().popBackStack()
            viewModel.addSuccess()
            }
        })
        binding.btnCancel.setOnClickListener {view->
            view.findNavController().popBackStack()
        }

        return binding.root
    }


}