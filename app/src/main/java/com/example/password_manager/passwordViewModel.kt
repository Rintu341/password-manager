package com.example.password_manager

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.password_manager.data.DataList
import com.example.password_manager.data.User

class PasswordViewModel : ViewModel() {

    private val _dataList  = mutableStateListOf<User>()

    val dataList:List<User> = _dataList


    fun addUser(user:User)
    {
        _dataList.add(user)
    }
    fun removeUser(user:User)
    {
        _dataList.removeIf{it==user}
    }

}