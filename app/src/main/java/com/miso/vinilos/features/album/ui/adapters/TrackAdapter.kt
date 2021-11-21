package com.miso.vinilos.features.album.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miso.vinilos.R
import com.miso.vinilos.features.album.domain.entities.Track

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.album.ui.adapters
 * Created by Miguel Zapata on 20/11/2021 at 6:51 p. m.
 * All rights reserved 2021.
 ****/

class TrackAdapter(private var context: Context, private var tracks: List<Track>): RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    class TrackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTrack: TextView = view.findViewById(R.id.txtNumber)
        var nameTrack: TextView = view.findViewById(R.id.txtNameSong)
        var durationTrack: TextView = view.findViewById(R.id.txtDurationSong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_songs,parent,false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track: Track = tracks.get(position)
        holder.itemTrack.text = (position+1).toString()
        holder.nameTrack.text = track.name
        holder.durationTrack.text = track.duration
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

}