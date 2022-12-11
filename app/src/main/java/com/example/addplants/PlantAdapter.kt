package com.example.addplants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.addplants.databinding.PlantsBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    val listItem = ArrayList<Plants>()
    class PlantHolder(inem: View): RecyclerView.ViewHolder(inem){
        val binding = PlantsBinding.bind(inem)
        fun bind (plant: Plants) = with(binding){
            im.setImageResource(plant.imageId)
            tvP.text = plant.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plants, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun addPlant(plant: Plants){
        listItem.add(plant)
        notifyDataSetChanged()
    }

}