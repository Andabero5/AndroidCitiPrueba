package com.example.auth.domain

import com.example.auth.data.remote.AuthDataSource

interface AuthRepo {
    suspend fun signUp (mail:String, password:String, name:String, DOB:String)
}