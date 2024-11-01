package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.interests.InterestDbModel
import com.example.data.database.interests.InterestsDao
import com.example.data.database.interests.UsersInterestsDbModel
import com.example.data.database.user.UserDao
import com.example.data.database.user.UserDbModel

@Database(
    entities = [InterestDbModel::class, UsersInterestsDbModel::class, UserDbModel::class],
    version = 4,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "mockData.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
//                        .createFromAsset(DB_NAME)
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun interestsDao(): InterestsDao
    abstract fun userDao(): UserDao
}