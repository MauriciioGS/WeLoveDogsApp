package mx.mauriciogs.welovedogsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mx.mauriciogs.welovedogsapp.R
import mx.mauriciogs.welovedogsapp.data.model.DogObject
import mx.mauriciogs.welovedogsapp.databinding.ActivityMainBinding
import mx.mauriciogs.welovedogsapp.ui.adapter.DogAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogsViewModel : DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogsViewModel.loadDogs()
        initBinding()
        initObserver()
    }

    private fun initBinding() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.run {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }
    }

    private fun initObserver() {
        dogsViewModel.getDogs().observe(this, Observer { result ->
            setRecyclerData(result)
        })
    }

    private fun setRecyclerData(dogsList: List<DogObject>?) {
        with(binding.recyclerView){
            adapter = dogsList?.let { DogAdapter(it) }
        }
    }

}