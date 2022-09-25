package com.example.roomdatabase.dao

import androidx.room.*
import com.example.roomdatabase.data.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_data ORDER BY id ASC")
    fun readAllData(): Flow<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_data")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_data WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

}