package com.example.data.database

//@Database(
//    entities = [],
//    version = 1,
//    exportSchema = false
//)
//internal abstract class AppDatabase : RoomDatabase() {
//    companion object {
//
//        private var db: AppDatabase? = null
//        private const val DB_NAME = "main.db"
//        private val LOCK = Any()
//
//        fun getInstance(context: Context): AppDatabase {
//            synchronized(LOCK) {
//                db?.let { return it }
//                val instance =
//                    Room.databaseBuilder(
//                        context,
//                        AppDatabase::class.java,
//                        DB_NAME
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                db = instance
//                return instance
//            }
//        }
//    }
//}