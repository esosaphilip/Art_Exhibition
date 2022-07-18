package com.example.artplay.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artplay.model.ArtBook
import com.example.artplay.repo.ArtRepositoryInterface
import com.example.artplay.roomdb.Art
import com.example.artplay.utils.Resource
import kotlinx.coroutines.launch

class ArtViewModel(private val  repository : ArtRepositoryInterface): ViewModel() {
    val artList = repository.getArt()

    private val images = MutableLiveData<Resource<ArtBook>>()
    val imageList : LiveData<Resource<ArtBook>>
        get() = images

    private val selectedImage = MutableLiveData<String>()
    val selectedImageUrl : LiveData<String>
        get() = selectedImage

    private var insertArtMsg = MutableLiveData<Resource<Art>>()
    val insertArtMessage : LiveData<Resource<Art>>
        get() = insertArtMsg

    //Solving the navigation bug
    fun resetInsertArtMsg() {
        insertArtMsg = MutableLiveData<Resource<Art>>()
    }

    fun setSelectedImage(url : String) {
        selectedImage.postValue(url)
    }

    fun deleteArt(art: Art) = viewModelScope.launch {
        repository.deleteArt(art)
    }

    fun insertArt(art: Art) = viewModelScope.launch {
        repository.insertArt(art)
    }

    fun makeArt(name : String, artistName : String, year : String) {
        if (name.isEmpty() || artistName.isEmpty() || year.isEmpty() ) {
            insertArtMsg.postValue(Resource.error("Enter name, artist, year", null))
            return
        }
        val yearInt = try {
            year.toInt()
        } catch (e: Exception) {
            insertArtMsg.postValue(Resource.error("Year should be number",null))
            return
        }

        val art = Art(name, artistName, yearInt,selectedImage.value?: "")
        insertArt(art)
        setSelectedImage("")
        insertArtMsg.postValue(Resource.success(art))
    }

    fun searchForImage (searchString : String) {

        if(searchString.isEmpty()) {
            return
        }
        images.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.searchImage(searchString)
            images.value = response
        }
    }

}