package mx.mauriciogs.welovedogsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogObject(
    @SerializedName("dogName") var name : String,
    @SerializedName("description") var desc : String,
    @SerializedName("age") var age : Int,
    @SerializedName("image") var urlPhoto : String
) : Parcelable

