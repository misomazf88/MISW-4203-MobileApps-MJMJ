package com.miso.vinilos.features.artist.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miso.vinilos.R
import com.miso.vinilos.features.album.domain.entities.Album

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.adapters
 * Created by Milena Castillo on 21/11/2021 at 3:51 p. m.
 * All rights reserved 2021.
 ****/

class AlbumsAdapter (private var albums: List<Album>): RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    class AlbumsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemAlbum: TextView = view.findViewById(R.id.txtNumberAlbum)
        var nameAlbum: TextView = view.findViewById(R.id.txtNameAlbum)
        var genreAlbum: TextView = view.findViewById(R.id.txtGenreAlbum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_albums,parent,false)
        return AlbumsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album: Album = albums.get(position)
        holder.itemAlbum.text = (position+1).toString()
        holder.nameAlbum.text = album.name
        holder.genreAlbum.text = album.genre
    }

    override fun getItemCount(): Int {
        return albums.size
    }

}