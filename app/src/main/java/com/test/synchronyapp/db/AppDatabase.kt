package com.test.synchronyapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.synchronyapp.models.entity.UserProfileEntity

@Database(entities = [UserProfileEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    /**
     * Return Dao instance.
     */
    abstract fun getUserProfileDao(): UserProfileDao

    companion object {
        private var DB_INSTANCE: AppDatabase? = null

        /**
         * Return app database instance.
         */
        fun getAppDBInstance(context: Context): AppDatabase {
            if(DB_INSTANCE == null) {
                DB_INSTANCE =  Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "APP_DB")
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}