package com.mukireus.earthquakelistkotlin.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mukireus.earthquakelistkotlin.Core.Model.Feature
import com.mukireus.earthquakelistkotlin.R
import kotlinx.android.synthetic.main.earthquake_list_card.view.*

class QuakeDataAdapter(
    var dataList: List<Feature>
) :
    RecyclerView.Adapter<QuakeDataAdapter.RowHolder>() {
    private val images: String =
        "https://images.unsplash.com/photo-1498550744921-75f79806b8a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"


    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(quakeModel: Feature) {
            itemView.itemTitle.text = quakeModel.properties.mag.toString()
            itemView.itemSubtitle.text = quakeModel.properties.place
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.earthquake_list_card, parent, false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.apply {
            Glide.with(this)
                .load(images)
                .into(image_view_item)
        }

    }


}