package com.example.addplants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.addplants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(R.drawable.plant0,
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5)
    var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }


    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,2)
            rcView.adapter = adapter
            addButton.setOnClickListener {
                if (index > 5) index = 0
                val plant = Plants(imageIdList[index],"Plant: $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}