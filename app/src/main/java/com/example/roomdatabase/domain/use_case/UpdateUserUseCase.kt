package com.example.roomdatabase.domain.use_case

import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.data.repository.UserRepositoryImpl
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val userRepositoryImpl: UserRepositoryImpl){

    suspend fun updateUser(user: User){
        userRepositoryImpl.updateUser(user)
    }
}