package com.example.artplay.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Art::class], version = 1, exportSchema = false)
abstract class ArtDatabase: RoomDatabase() {

    abstract fun artDao():ArtDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ArtDatabase? = null

        fun getDatabase(context: Context): ArtDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArtDatabase::class.java,
                    "art_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
