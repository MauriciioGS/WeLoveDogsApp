package mx.mauriciogs.welovedogsapp.data.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.data.network.RetrofitBuilder

class DogsService(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val client = RetrofitBuilder.api

    suspend fun getDogs() : List<DogObject>?{
        return withContext(dispatcher){
            val response = client.getDogs("945366962796773376")
            response.body()
        }
    }
}