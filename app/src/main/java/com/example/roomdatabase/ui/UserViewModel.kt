package com.example.roomdatabase.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.model.User
import com.example.roomdatabase.domain.use_case.AddUserUseCase
import com.example.roomdatabase.domain.use_case.DeleteUserUseCase
import com.example.roomdatabase.domain.use_case.GetUsersUseCase
import com.example.roomdatabase.domain.use_case.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor
    (private val addUserUseCase: AddUserUseCase,
     private val deleteUserUseCase: DeleteUserUseCase,
     private val updateUserUseCase: UpdateUserUseCase,
     private val getUsersUseCase: GetUsersUseCase,
) : ViewModel(){

    val readAllData: Flow<List<User>> = getUsersUseCase.readAllData

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            addUserUseCase.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            updateUserUseCase.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            deleteUserUseCase.deleteUser(user)
        }
    }

    fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO){
            deleteUserUseCase.deleteAllUsers()
        }
    }
}