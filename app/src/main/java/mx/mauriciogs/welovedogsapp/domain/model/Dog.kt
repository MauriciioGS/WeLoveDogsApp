package mx.mauriciogs.welovedogsapp.domain.model

import mx.mauriciogs.welovedogsapp.data.database.entities.DogEntity
import mx.mauriciogs.welovedogsapp.data.model.DogObject

data class Dog(
    val name: String,
    val desc: String,
    val age: Int,
    val urlPhoto: String
)

fun DogObject.toDomain() = Dog(name, desc, age, urlPhoto)
fun DogEntity.toDomain() = Dog(name, desc, age, urlPhoto)