package mx.mauriciogs.welovedogsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.mauriciogs.welovedogsapp.data.model.DogObject

class DogsViewModel : ViewModel() {
    val dogsModel = MutableLiveData<DogObject>()

}