package com.example.artplay.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.artplay.adapter.ArtRecyclerAdapter
import com.example.artplay.adapter.ImageRecyclerAdapter

class ArtFragmentFactory(
    private val imageRecyclerAdapter: ImageRecyclerAdapter,
    private val glide : RequestManager,
    private val artRecyclerAdapter: ArtRecyclerAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImageApi::class.java.name -> ImageApi(imageRecyclerAdapter)
            ArtPlay::class.java.name -> ArtPlay(glide)
            ArtList::class.java.name -> ArtList(artRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}