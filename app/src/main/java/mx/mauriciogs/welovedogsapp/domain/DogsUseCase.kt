package mx.mauriciogs.welovedogsapp.domain

import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.data.remote_repository.DogsRepository

class DogsUseCase {
    private val repository = DogsRepository()

    suspend fun getAllDogs() : List<DogObject>? = repository.getAllDogs()
}