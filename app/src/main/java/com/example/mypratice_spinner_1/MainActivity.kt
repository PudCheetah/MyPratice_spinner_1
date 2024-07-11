package com.example.mypratice_spinner_1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_spinner_1.databinding.ActivityMainBinding
import java.util.Objects

//
//
//
//Adapter寫法1
//
//
//

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Adapter寫法1
        val myResourse = resources.getStringArray(R.array.MySpinners)
        var myAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_single_choice, myResourse)
        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        binding.MyspinnerMainActivity.adapter = myAdapter

//        監聽器
        binding.MyspinnerMainActivity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                Toast.makeText(this@MainActivity, "選擇了 ${position}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        setContentView(binding.root)
    }
}