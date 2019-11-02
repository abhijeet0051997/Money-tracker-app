package com.example.pocket_man

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.pocket_man.Fragments.MainFragment
import com.example.pocket_man.Fragments.UpdateFragment
import com.example.pocket_man.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainFragment.OnAddbuttonClickListener {
    override fun onAddButonClicked() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,UpdateFragment())
            .addToBackStack(null).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,MainFragment())
            .addToBackStack(null).commit()

    }
}

