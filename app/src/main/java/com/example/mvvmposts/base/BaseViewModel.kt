package com.example.mvvmposts.base

import androidx.lifecycle.ViewModel
import com.example.mvvmposts.injection.component.DaggerViewModelInjector
import com.example.mvvmposts.injection.component.ViewModelInjector
import com.example.mvvmposts.injection.module.NetworkModule
import com.example.mvvmposts.ui.user.UserListViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is UserListViewModel -> injector.inject(this)
        }
    }
}