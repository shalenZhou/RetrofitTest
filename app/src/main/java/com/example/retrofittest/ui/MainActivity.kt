package com.example.retrofittest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittest.ClickAction
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.setClickAction

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.getPlaceDataBtn.setClickAction(object : ClickAction {
            override fun invoke() {
                viewModel.showPlaceInfo()
            }
        })
    }

}