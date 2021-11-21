package com.miso.vinilos.features.artist.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.miso.vinilos.R
import com.miso.vinilos.features.album.domain.entities.Album
import com.miso.vinilos.features.album.ui.adapters.AlbumAdapter
import com.miso.vinilos.features.album.ui.views.AlbumDetailActivity
import com.miso.vinilos.features.artist.domain.entities.Artist
import com.miso.vinilos.features.artist.ui.views.ArtistDetailActivity

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.artist.ui.adapters
 * Created by Miguel Zapata on 7/11/2021 at 6:05 p. m.
 * All rights reserved 2021.
 ****/

class ArtistAdapter (private var context: Context, private var artists: List<Artist>): RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    class ArtistViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageArtist: ImageView
        var nameArtist: TextView
        var containerArtist: ConstraintLayout
        init {
            imageArtist = view.findViewById(R.id.imageArtist)
            nameArtist = view.findViewById(R.id.nameArtist)
            containerArtist = view.findViewById(R.id.containerArtist)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.grid_artistas,parent,false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist: Artist = artists.get(position)
        Glide.with(context)
            .load(artist.image)
            .skipMemoryCache(true)
            .into(holder.imageArtist)
        holder.nameArtist.setText(artist.name)
        holder.nameArtist.isSelected = true
        holder.containerArtist.setOnClickListener {
            val gson = Gson()
            val intent = Intent(context, ArtistDetailActivity::class.java)
            intent.putExtra("artist", gson.toJson(artist))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return artists.size
    }
}