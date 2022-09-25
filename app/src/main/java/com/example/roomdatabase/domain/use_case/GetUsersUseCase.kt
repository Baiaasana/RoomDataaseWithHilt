package com.example.roomdatabase.domain.use_case

import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.data.repository.UserRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepositoryImpl: UserRepositoryImpl) {

//    suspend fun getData(): Flow<List<User>> = userRepositoryImpl.readAllData

    val readAllData: Flow<List<User>> = userRepositoryImpl.readAllData
}