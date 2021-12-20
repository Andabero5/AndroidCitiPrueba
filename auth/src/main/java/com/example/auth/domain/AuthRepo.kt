package com.example.auth2.domain

interface AuthRepo {
    suspend fun signUp (mail:String, password:String, name:String, DOB:String)
}