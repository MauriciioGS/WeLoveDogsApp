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

    fun loadDogs(){
        viewModelScope.launch {
            val response = getDogsUseCase.getAllDogs()
            response?.let { dogsList ->
                dogs.postValue(dogsList)
            }
        }
    }

    fun getDogs() = dogs

}