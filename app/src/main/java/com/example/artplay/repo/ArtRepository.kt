package com.example.artplay.repo

import androidx.lifecycle.LiveData
import com.example.artplay.model.ArtBook
import com.example.artplay.network.ArtInterface
import com.example.artplay.roomdb.Art
import com.example.artplay.roomdb.ArtDao
import com.example.artplay.utils.Resource

class ArtRepository(private val artDao: ArtDao, private val retroApi: ArtInterface): ArtRepositoryInterface {
    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
       artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArt()
    }

    override suspend fun searchImage(imageString: String): Resource<ArtBook> {
        return try {
            val response = retroApi.getPhotos(imageString)
           if (response.isSuccessful){
               response.body()?.let{
                   return@let Resource.success(it)
               }?: Resource.error("Error",null)
           } else {
               Resource.error("Error",null)
           }

        } catch (e: Exception){
            Resource.error("No Data!",null)
        }
    }
}