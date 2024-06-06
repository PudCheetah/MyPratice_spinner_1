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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        //Adapter寫法1
        val items = listOf("選項 1", "選項 2", "選項 3")
        val myResourse = resources.getStringArray(R.array.MySpinners)
        var myAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_single_choice, myResourse)
        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        binding.MyspinnerMainActivity.adapter = myAdapter
        //監聽器
        binding.MyspinnerMainActivity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "選擇了 ${position}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        //寫法2
        ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_list_item_single_choice).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
            binding.MyspinnerMainActivity.adapter = adapter
            //dropDownVerticalOffset設定可以讓下拉選單的位置偏移
            binding.MyspinnerMainActivity.dropDownVerticalOffset = 100
        }
        //監聽器
        binding.MyspinnerMainActivity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when(position){
                    0 -> {Toast.makeText(this@MainActivity, "選擇了 ${position}", Toast.LENGTH_SHORT).show()}
                    1 -> {Toast.makeText(this@MainActivity, "選擇了 ${position}", Toast.LENGTH_SHORT).show()}
                    else -> {Toast.makeText(this@MainActivity, "選擇了其他", Toast.LENGTH_SHORT).show()}
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //寫法3(就是寫法2不使用apply版)
        var myArrayAdapter = ArrayAdapter.createFromResource(this, R.array.planets_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice)
        binding.MyspinnerMainActivity.adapter = myArrayAdapter

        setContentView(binding.root)
    }
}