package com.keepcoding.instagramparapobres.galleryDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keepcoding.instagramparapobres.databinding.GalleryDetailsItemBinding

class GalleryDetailsRecyclerAdapter : RecyclerView.Adapter<GalleryDetailsViewHolder>() {

    var imageUrlList: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryDetailsViewHolder =
        GalleryDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { GalleryDetailsViewHolder(this) }

    override fun onBindViewHolder(holder: GalleryDetailsViewHolder, position: Int) {
        holder.bind(imageUrlList[position])
    }

    override fun getItemCount(): Int = imageUrlList.size
}

data class GalleryDetailsViewHolder(val binding: GalleryDetailsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String) {
        with(binding) {
            Glide.with(root).load(imageUrl).into(imageView)
        }
    }
}