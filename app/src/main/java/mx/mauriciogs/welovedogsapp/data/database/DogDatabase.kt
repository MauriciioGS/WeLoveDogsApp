package mx.mauriciogs.welovedogsapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.mauriciogs.welovedogsapp.data.database.dao.DogObjectDao
import mx.mauriciogs.welovedogsapp.data.database.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1)
abstract class DogDatabase : RoomDatabase() {

    abstract fun getDogObjectDao() : DogObjectDao

    companion object {
        @Volatile
        private var INSTANCE: DogDatabase? = null

        fun getDatabase(context: Context): DogDatabase {
            if(INSTANCE == null){
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE as DogDatabase
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, DogDatabase::class.java, "dog_db").build()
    }

}