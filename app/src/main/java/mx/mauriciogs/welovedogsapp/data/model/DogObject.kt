package mx.mauriciogs.welovedogsapp.data.model

import com.google.gson.annotations.SerializedName

data class DogObject(
    @SerializedName("dogName") var name : String,
    @SerializedName("description") var desc : String,
    @SerializedName("age") var age : Int,
    @SerializedName("url") var urlPhoto : String
)
