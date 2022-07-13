package mx.mauriciogs.welovedogsapp.data.remote_repository

import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.data.service.DogsService

class DogsRepository {
    private val api = DogsService()

    suspend fun getAllDogs() : List<DogObject>?{
        return api.getDogs()
    }
}