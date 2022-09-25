package com.example.roomdatabase.data.repository

import com.example.roomdatabase.dao.UserDao
import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.domain.repositoy.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : Repository {

    val readAllData: Flow<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

    override suspend fun readData(): Flow<List<User>> = userDao.readAllData()

}