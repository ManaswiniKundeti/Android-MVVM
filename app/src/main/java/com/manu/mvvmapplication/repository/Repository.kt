package com.manu.mvvmapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manu.mvvmapplication.api.IUserService
import com.manu.mvvmapplication.api.createUserService
import com.manu.mvvmapplication.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val userService: IUserService): IRepository {

    private val TAG = Repository::class.java.simpleName

    private val _userLiveData: MutableLiveData<User> = MutableLiveData()

    val userLiveData: LiveData<User> = _userLiveData

    override fun fetchUser() {
        userService.getUser().enqueue(object: Callback<User> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e(TAG, "Error fetching user details", t)
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    _userLiveData.postValue(response.body())
                }
            }

        })
    }
}