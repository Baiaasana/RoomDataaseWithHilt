package com.example.roomdatabase.domain.use_case

import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.data.repository.UserRepositoryImpl
import javax.inject.Inject

class AddUserUseCase @Inject constructor(private val userRepositoryImpl: UserRepositoryImpl){

    suspend fun addUser(user: User){
        userRepositoryImpl.addUser(user)
    }

}