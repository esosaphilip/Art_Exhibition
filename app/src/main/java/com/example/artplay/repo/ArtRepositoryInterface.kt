package com.example.artplay.repo

import androidx.lifecycle.LiveData
import com.example.artplay.model.ArtBook
import com.example.artplay.roomdb.Art
import com.example.artplay.utils.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>
    suspend fun searchImage(imageString: String) : Resource<ArtBook>
}