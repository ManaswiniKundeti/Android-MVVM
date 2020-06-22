package com.manu.mvvmapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manu.mvvmapplication.api.createUserService
import com.manu.mvvmapplication.repository.Repository
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory() : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(Repository(createUserService())) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}