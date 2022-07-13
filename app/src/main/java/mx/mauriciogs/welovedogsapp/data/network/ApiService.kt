package mx.mauriciogs.welovedogsapp.data.network

import mx.mauriciogs.welovedogsapp.data.model.DogObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getDogs(@Url url: String) : Response<List<DogObject>>
}