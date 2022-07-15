package mx.mauriciogs.welovedogsapp.data

import androidx.lifecycle.map
import mx.mauriciogs.welovedogsapp.data.database.dao.DogObjectDao
import mx.mauriciogs.welovedogsapp.data.database.entities.DogEntity
import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.data.service.DogsService
import mx.mauriciogs.welovedogsapp.domain.model.Dog
import mx.mauriciogs.welovedogsapp.domain.model.toDomain

class DogsRepository(
    private val dogObjectDao : DogObjectDao
) {
    private val api = DogsService()

    suspend fun getAllDogsFromRemote() : List<Dog>?{
        return api.getDogs()?.map { it.toDomain() }
    }

    suspend fun getAllDogsFromDatabase() : List<Dog>{
        return dogObjectDao.getAllDogs().map { it.toDomain() }
    }

    suspend fun insertDogs(dogs:List<DogEntity>){
        dogObjectDao.insertAll(dogs)
    }

    suspend fun clearList(){
        dogObjectDao.deleteAllDogs()
    }

}