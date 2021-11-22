package com.miso.vinilos.features.collector.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miso.vinilos.R
import com.miso.vinilos.features.collector.domain.entities.Collector

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.collector.ui.adapters
 * Created by Jhonnatan E. Zamudio P. on 21/11/2021 at 8:40 p. m.
 * All rights reserved 2021.
 ****/

class CollectorAdapter(private var collectors: List<Collector>): RecyclerView.Adapter<CollectorAdapter.CollectorViewHolder>() {

    class CollectorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemCollector: TextView = view.findViewById(R.id.txtIdCollector)
        var nameCollector: TextView = view.findViewById(R.id.txtName)
        var emailCollector: TextView = view.findViewById(R.id.txtEmail)
        var buttonDetail: Button = view.findViewById(R.id.btnDetailCollector)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.grid_collectors,parent,false)
        return CollectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectorViewHolder, position: Int) {
        val collector: Collector = collectors.get(position)
        holder.itemCollector.text = (position+1).toString()
        holder.nameCollector.text = collector.name
        holder.emailCollector.text = collector.email
    }

    override fun getItemCount(): Int {
        return collectors.size
    }

}