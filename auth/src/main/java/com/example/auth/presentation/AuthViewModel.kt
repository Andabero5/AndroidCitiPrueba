package com.example.auth2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.auth2.domain.AuthRepo
import com.example.auth.core.Result


class AuthViewModel(val repo: AuthRepo) : ViewModel() {
    fun signUp(mail: String, password: String, name: String, DOB: String) = liveData {
        emit(Result.Loading())
        try{
            emit(Result.Success(repo.signUp(mail, password, name, DOB)))
        }catch (e: Exception){
            emit(Result.Failure(e))
        }
    }
}
class AuthViewModelFactory (val repo: AuthRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repo) as T
    }
}