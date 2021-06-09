package com.keepcoding.instagramparapobres.gallery


data class Gallery(val images: List<Image>)
data class Image(
    val id: String,
    val title: String?,
    val imageUrls: List<String>,
    val likes: Int,
    val datetime: Long,
    val author: String?
) {
    val authorAvatar: String by lazy {
        "https://imgur.com/user/${author}/avatar"
    }
}
