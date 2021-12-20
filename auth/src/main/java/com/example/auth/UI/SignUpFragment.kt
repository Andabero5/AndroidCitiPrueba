package com.example.auth2.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.auth.R
import com.example.auth.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {


private lateinit var binding: FragmentSignUpBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

    }

}