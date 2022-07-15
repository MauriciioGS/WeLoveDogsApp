package mx.mauriciogs.welovedogsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.domain.DogsUseCase

class DogsViewModel : ViewModel() {

    private val dogs = MutableLiveData<List<DogObject>>()
    private var getDogsUseCase = DogsUseCase()
    val loading = MutableLiveData<Boolean>()

    fun loadDogs(){
        viewModelScope.launch {
            loading.postValue(true)
            val response = getDogsUseCase.getAllDogs()
            response?.let { dogsList ->
                dogs.postValue(dogsList)
                loading.postValue(false)
            }
        }
    }

    fun getDogs() = dogs

}