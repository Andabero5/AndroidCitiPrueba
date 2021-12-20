package com.example.auth.presentación

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.auth.domain.AuthRepo

class AuthViewModel(val repo: AuthRepo) : ViewModel() {
    suspend fun signUp(mail: String, password: String, name: String, DOB: String) = liveData {
        try{
            emit(Result.success(repo.signUp(mail, password, name, DOB)))
        }catch (e: Exception){
            emit(Result.failure(e))
        }
    }
}