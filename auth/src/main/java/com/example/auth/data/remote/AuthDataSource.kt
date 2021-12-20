package com.example.auth.data.remote

import com.example.auth.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class AuthDataSource {
    suspend fun signUp(mail:String, password:String, name:String, DOB:String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,password).await()
        val user = User(name, mail,DOB)
        FirebaseFirestore.getInstance().collection("user").document().set(user).await()
    }
}