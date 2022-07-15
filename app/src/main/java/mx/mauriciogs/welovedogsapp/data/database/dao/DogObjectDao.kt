package mx.mauriciogs.welovedogsapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mx.mauriciogs.welovedogsapp.data.database.entities.DogEntity

@Dao
interface DogObjectDao {
    @Query("SELECT * FROM dog_table ORDER BY name DESC")
    suspend fun getAllDogs():List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dogs : List<DogEntity>)

    @Query("DELETE FROM dog_table")
    suspend fun deleteAllDogs()
}