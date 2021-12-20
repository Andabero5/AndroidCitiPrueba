package com.example.auth.domain

import com.example.auth.data.remote.AuthDataSource

class AuthRepoImpl:AuthRepo {
    override suspend fun signUp(mail: String, password: String, name: String, DOB: String) = AuthDataSource().signUp(mail, password, name, DOB)

}