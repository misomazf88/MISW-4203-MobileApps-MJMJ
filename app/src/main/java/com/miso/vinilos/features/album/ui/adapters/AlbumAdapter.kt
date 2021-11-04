package com.miso.vinilos.features.album.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.miso.vinilos.R

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.adapters
 * Created by Jhonnatan E. Zamudio P. on 4/11/2021 at 1:42 p. m.
 * All rights reserved 2021.
 ****/

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageAlbum: ImageView
        var titleAlbum: TextView
        var artistAlbum: TextView
        var containerAlbum: ConstraintLayout
        init {
            imageAlbum = view.findViewById(R.id.imageAlbum)
            titleAlbum = view.findViewById(R.id.titleAlbum)
            artistAlbum = view.findViewById(R.id.artistAlbum)
            containerAlbum = view.findViewById(R.id.containerAlbum)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.grid_albumes,parent,false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.containerAlbum.setOnClickListener {
            println("La posición seleccionada es: $position")
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}