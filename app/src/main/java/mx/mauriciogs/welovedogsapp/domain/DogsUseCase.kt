package mx.mauriciogs.welovedogsapp.domain

import mx.mauriciogs.welovedogsapp.data.DogsRepository
import mx.mauriciogs.welovedogsapp.data.database.dao.DogObjectDao
import mx.mauriciogs.welovedogsapp.data.database.entities.toDatabase
import mx.mauriciogs.welovedogsapp.domain.model.Dog

class DogsUseCase(
    private val dogObjectDao : DogObjectDao
) {
    private val repository = DogsRepository(dogObjectDao)

    suspend fun getAllDogs() : List<Dog>{
        val dogsList = repository.getAllDogsFromRemote()

        return if(dogsList?.isNotEmpty() == true){
            repository.clearList()
            repository.insertDogs(dogsList.map { it.toDatabase() })
            dogsList
        }else {
            repository.getAllDogsFromDatabase()
        }
    }

}