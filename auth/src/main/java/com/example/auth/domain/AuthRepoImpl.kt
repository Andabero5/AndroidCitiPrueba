package com.example.auth2.domain

import com.example.auth2.data.remote.AuthDataSource

class AuthRepoImpl:AuthRepo {
    override suspend fun signUp(mail: String, password: String, name: String, DOB: String) = AuthDataSource().signUp(mail, password, name, DOB)

}