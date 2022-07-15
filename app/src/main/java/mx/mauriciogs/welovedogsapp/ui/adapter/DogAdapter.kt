package mx.mauriciogs.welovedogsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.mauriciogs.welovedogsapp.databinding.ItemDogBinding
import mx.mauriciogs.welovedogsapp.domain.model.Dog

class DogAdapter(private val dogsList: List<Dog>) : RecyclerView.Adapter<DogAdapter.DogsViewHolder>() {

    class DogsViewHolder(private val itemBinding: ItemDogBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(dogObject: Dog) {
            Glide.with(itemView.context)
                .load(dogObject.urlPhoto)
                .centerCrop()
                .into(itemBinding.ivPhoto)
            itemBinding.tvName.text = dogObject.name
            itemBinding.tvDesc.text = dogObject.desc
            itemBinding.tvAge.text = dogObject.age.toString() + " years"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDogBinding.inflate(inflater, parent, false)
        return DogsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        holder.bind(dogsList[position])
    }

    override fun getItemCount() = dogsList.size
}