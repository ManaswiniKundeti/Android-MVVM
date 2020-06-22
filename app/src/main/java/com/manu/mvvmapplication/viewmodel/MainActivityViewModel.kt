package com.manu.mvvmapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.manu.mvvmapplication.data.User
import com.manu.mvvmapplication.repository.Repository

class MainActivityViewModel(repository: Repository) : ViewModel() {

    private val TAG = MainActivityViewModel::class.java.simpleName

    val userLiveData: LiveData<User> = repository.userLiveData

    init {
        repository.fetchUser()
    }
}