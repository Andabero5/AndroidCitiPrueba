package com.example.auth2.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.auth.R
import com.example.auth.core.Result
import com.example.auth.databinding.FragmentSignUpBinding
import com.example.auth2.data.remote.AuthDataSource
import com.example.auth2.domain.AuthRepoImpl
import com.example.auth2.presentation.AuthViewModel
import com.example.auth2.presentation.AuthViewModelFactory

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val viewModel by viewModels<AuthViewModel> {
        AuthViewModelFactory(
            AuthRepoImpl(
                AuthDataSource()
            )
        )
    }

    private lateinit var binding: FragmentSignUpBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        binding.btnRegister.setOnClickListener {
            signUp()
        }

    }

    private fun signUp() {
        val name = binding.etUsername.text.toString().trim()
        val mail = binding.etEmail.text.toString().trim()
        val dob = binding.etDOB.text.toString().trim()
        val password = binding.etPassword.toString().trim()
        viewModel.signUp(mail,password,name,dob).observe(viewLifecycleOwner, {result ->
            when(result){
                is Result.Loading -> {
                    binding.progressBar.visibility = VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = GONE
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = GONE
                    Toast.makeText(requireContext(), "Error ${result.exception}", Toast.LENGTH_LONG)
                        .show()
                }
            }


        })
    }


}