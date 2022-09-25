package com.example.roomdatabase.domain.use_case

import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.data.repository.UserRepositoryImpl
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(private val userRepositoryImpl: UserRepositoryImpl) {

    suspend fun deleteUser(user: User) {
        userRepositoryImpl.deleteUser(user)

    }

    suspend fun deleteAllUsers() {
        userRepositoryImpl.deleteAllUsers()
    }
}