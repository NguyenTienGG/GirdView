package com.example.b11

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b11.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val list = mutableListOf<OurData>()
        list.add(OurData(R.drawable.zoro, "Zoro"))
        list.add(OurData(R.drawable.nami, "Nami"))
        list.add(OurData(R.drawable.sanji, "Sanji"))
        list.add(OurData(R.drawable.jinbei, "Jinbei"))

        val customGV = CustomGridView(this, list)
        binding.GVMovie.adapter = customGV

        // click event
        binding.GVMovie.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You clicked on ${list[position].title}", Toast.LENGTH_SHORT).show()
        }
    }
}