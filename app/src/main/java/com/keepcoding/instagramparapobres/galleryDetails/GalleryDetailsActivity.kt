package com.keepcoding.instagramparapobres.galleryDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.keepcoding.instagramparapobres.databinding.GalleryDetailsActivityBinding

class GalleryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = GalleryDetailsActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val imageUrls = intent.getStringArrayListExtra(IMAGE_URLS)

        val adapter = GalleryDetailsRecyclerAdapter()
        binding.galleryDetailsRecyclerView.adapter = adapter
        if (imageUrls != null) adapter.imageUrlList = imageUrls
    }

    companion object {
        private const val IMAGE_URLS = "imageUrls"

        @JvmStatic
        fun createIntent(context: Context, imageUrls: ArrayList<String>): Intent =
            Intent(context, GalleryDetailsActivity::class.java).apply {
                putStringArrayListExtra(IMAGE_URLS, imageUrls)
            }
    }
}