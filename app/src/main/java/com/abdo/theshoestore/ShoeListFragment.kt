package com.abdo.theshoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abdo.theshoestore.databinding.FragmentShoeListBinding
import com.abdo.theshoestore.databinding.ItemListBinding


class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding:FragmentShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,R.layout.fragment_shoe_list,container,false
        )
//        viewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.floatingActionButton.setOnClickListener {view->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListenFragmentToShoeDetialsFragment())
        }
        // observe shoeList to add new shoe to linearContainer
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            Toast.makeText(binding.root.context, it.toString(), Toast.LENGTH_SHORT).show()
            for (shoe in it){
             binding.linearLayoutContainer.addView(addShoeToView(shoe))
            }
        })
        // set toolbar
        setHasOptionsMenu(true)

        return binding.root
    }
    // method to add childView to linearLayoutContainer
    private fun addShoeToView(shoe: Shoe,):View{
        val childView = DataBindingUtil.inflate<ItemListBinding>(
            layoutInflater,R.layout.item_list
            ,binding.linearLayoutContainer,false
        )
        childView.shoe=shoe
        return childView.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_overflow,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // navigate to loginFragment
        return when (item.itemId){
            R.id.logout->{
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}