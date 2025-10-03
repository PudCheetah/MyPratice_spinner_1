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
    // 使用 view binding 簡化視圖元件的存取
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 從三種方法中選擇一種來初始化 Spinner
//        spinnerSet_createFromResource()  // 使用createFromResource() 來生成spinner
//        spinnerSet_ArrayAdapter_getResFromXML()  // 使用ArrayAdapter()獲取xml來源的資料生成spinner
//        spinnerSet_ArrayAdapter_getResFromArray()  // 使用ArrayAdapter()獲取程式碼生成的array陣列來生成spinner

        // 設定 Spinner 的項目選擇監聽器
        binding.spinMySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            // 當選擇項目時觸發
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "你選擇了第 ${position + 1} 選項", Toast.LENGTH_SHORT).show()
            }
            // 當沒有選擇任何項目時觸發
            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@MainActivity, "你沒有選擇任何一項", Toast.LENGTH_SHORT).show()
            }
        }
    }
    /**
     * 方法一：使用 ArrayAdapter.createFromResource() 從 XML 陣列建立 Spinner。
     * 這是最簡潔的靜態方法。
     */
    fun spinnerSet_createFromResource(){
        val adapter = ArrayAdapter.createFromResource(this,R.array.plantes, android.R.layout.simple_spinner_item)
        // 設定下拉選單的樣式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // 將適配器指派給 Spinner
        binding.spinMySpinner.adapter = adapter
    }
    /**
     * 方法二：使用 ArrayAdapter 建構式，手動讀取 XML 陣列來建立 Spinner。
     * 當需要對資料來源做額外處理時使用。
     */
    fun spinnerSet_ArrayAdapter_getResFromXML(){
        // 手動從 resources 獲取字串陣列
        val myRes = resources.getStringArray(R.array.plantes)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, myRes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinMySpinner.adapter = adapter
    }
    /**
     * 方法三：使用 ArrayAdapter 建構式，從程式碼中的陣列建立 Spinner。
     * 適用於動態產生的資料。
     */
    fun spinnerSet_ArrayAdapter_getResFromArray(){
        // 直接在程式碼中定義陣列
        val myArray = arrayOf("AAA", "BBB", "CCC", "DDD")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, myArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinMySpinner.adapter = adapter
    }
}
