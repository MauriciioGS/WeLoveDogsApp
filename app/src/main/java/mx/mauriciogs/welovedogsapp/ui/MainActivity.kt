package mx.mauriciogs.welovedogsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.mauriciogs.welovedogsapp.R
import mx.mauriciogs.welovedogsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}