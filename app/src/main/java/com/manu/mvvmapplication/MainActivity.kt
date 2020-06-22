package com.manu.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manu.mvvmapplication.data.User
import com.manu.mvvmapplication.viewmodel.MainActivityViewModel
import com.manu.mvvmapplication.viewmodel.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewmodelFactory by lazy { MainActivityViewModelFactory() }
    private val viewModel: MainActivityViewModel by viewModels {
        viewmodelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.userLiveData.observe(this,
            Observer<User> { user ->
                user_name_text_view.text = user?.name
                user_email_text_view.text = user?.email
            })
    }
}