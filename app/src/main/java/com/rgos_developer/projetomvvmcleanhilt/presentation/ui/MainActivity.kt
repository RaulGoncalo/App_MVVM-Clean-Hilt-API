package com.rgos_developer.projetomvvmcleanhilt.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rgos_developer.projetomvvmcleanhilt.R
import com.rgos_developer.projetomvvmcleanhilt.databinding.ActivityMainBinding
import com.rgos_developer.projetomvvmcleanhilt.presentation.viewModel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usersViewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        usersViewModel.users.observe(this){listUser ->
            var result = ""

            listUser.forEach {
                result += "Nome: ${it.firstName} - idade: ${it.age}) ${it.email} \n"
            }

            binding.textResult.text = result
        }
    }



}