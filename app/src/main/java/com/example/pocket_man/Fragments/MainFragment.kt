package com.example.pocket_man.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.pocket_man.R
import com.example.pocket_man.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var listener:OnAddbuttonClickListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false)
        binding.addBtn.setOnClickListener({
            listener.onAddButonClicked()
        })

        return binding.root
    }

    interface OnAddbuttonClickListener{
        fun onAddButonClicked()
    }


    override fun onAttach(context: Context) {
        if( context is OnAddbuttonClickListener)
            listener = context as OnAddbuttonClickListener
        else
            throw ClassCastException("Please implement methods")
        super.onAttach(context)
    }
}
