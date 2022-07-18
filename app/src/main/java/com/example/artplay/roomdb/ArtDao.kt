package com.example.artplay.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ArtDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(art: Art)

    @Query("SELECT * FROM arts")
    fun observeArt():LiveData<List<Art>>

    @Delete
    suspend fun deleteArt(art: Art)

}