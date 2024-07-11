package com.example.mypratice_spinner_1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_spinner_1.databinding.ActivityMainBinding

//
//
//
//Adapter寫法3(就是寫法2不使用apply版)
//
//
//
class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //寫法3(就是寫法2不使用apply版)
        var myArrayAdapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_dropdown_item)
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.MyspinnerMainActivity.adapter = myArrayAdapter
        //監聽器
        binding.MyspinnerMainActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when(position){
                    0 -> {
                        Toast.makeText(this@MainActivity3, "選擇了 ${position}", Toast.LENGTH_SHORT).show()}
                    1 -> {
                        Toast.makeText(this@MainActivity3, "選擇了 ${position}", Toast.LENGTH_SHORT).show()}
                    else -> {
                        Toast.makeText(this@MainActivity3, "選擇了其他", Toast.LENGTH_SHORT).show()}
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        setContentView(binding.root)
    }
}