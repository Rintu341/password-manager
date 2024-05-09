package com.example.password_manager

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.password_manager.data.User
import com.example.password_manager.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
//class PasswordViewModel(
//    private val userRepository: UserRepository
//) : ViewModel() {
//
//    /*
//    private val _dataList  = mutableStateListOf<User>()
//
//    val dataList:List<User> = _dataList
//
//
//    fun addUser(user:User)
//    {
//        _dataList.add(user)
//    }
//    fun removeUser(user:User)
//    {
//        _dataList.removeIf{it==user}
//    }
//     */
//
//}
*/

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val repository: UserRepository
):ViewModel()
{
    private var _readAllData = MutableStateFlow<List<User>>(emptyList())
    val readAllData = _readAllData.asStateFlow()


    init{
        viewModelScope.launch (Dispatchers.IO){
            repository.readAllData().distinctUntilChanged()
                .collect{listUser->
                    if(listUser.isEmpty())
                    {
                        Log.d("Empty","list empty")
                    }else
                    {
                        _readAllData.value = listUser
                    }
                }

        }
    }

    fun addUser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun removeUser(user:User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeUser(user)
        }
    }
}