package com.example.pocket_man.Fragments


import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil

import com.example.pocket_man.R
import com.example.pocket_man.databinding.FragmentUpdateBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class UpdateFragment : Fragment() {

    var spinner_data = mutableListOf<String>("Debit","Credit")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentUpdateBinding>(inflater,R.layout.fragment_update,container,false)
        val adapter  = activity?.let { ArrayAdapter<String>(it,android.R.layout.simple_spinner_dropdown_item,spinner_data) }
        binding.spinner.adapter = adapter
        binding.date.setOnClickListener({
            clickDataPicker()
        })

        return binding.root
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDataPicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(activity!!, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in Toast
            Toast.makeText(activity, """$dayOfMonth - ${monthOfYear + 1} - $year""", Toast.LENGTH_LONG).show()

        }, year, month, day)
        dpd.show()
    }

}
