package mx.mauriciogs.welovedogsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.mauriciogs.welovedogsapp.data.database.DogDatabase
import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.domain.DogsUseCase
import mx.mauriciogs.welovedogsapp.domain.model.Dog

class DogsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val dogDao = DogDatabase.getDatabase(application).getDogObjectDao()
    private var getDogsUseCase = DogsUseCase(dogDao)

    private val dogs = MutableLiveData<List<Dog>>()
    val loading = MutableLiveData<Boolean>()

    fun loadDogs(){
        viewModelScope.launch {
            loading.postValue(true)
            val response = getDogsUseCase.getAllDogs()
            response.let { dogsList ->
                dogs.postValue(dogsList)
                loading.postValue(false)
            }
        }
    }

    fun getDogs() = dogs

}