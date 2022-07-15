package mx.mauriciogs.welovedogsapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import mx.mauriciogs.welovedogsapp.domain.model.Dog

@Entity(tableName = "dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val desc: String,
    val age: Int,
    val urlPhoto: String,
)

fun Dog.toDatabase() = DogEntity(name = name, desc = desc, age = age, urlPhoto = urlPhoto)
