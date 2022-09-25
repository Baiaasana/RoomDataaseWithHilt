package com.example.roomdatabase.domain.repositoy

import com.example.roomdatabase.data.model.User
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun readData() : Flow<List<User>>

}