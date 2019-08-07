package com.example.mvvmposts.injection.component

import com.example.mvvmposts.injection.module.NetworkModule
import com.example.mvvmposts.ui.user.UserDetailViewModel
import com.example.mvvmposts.ui.user.UserListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified UserListViewModel.
     * @param userListViewModel UserListViewModel in which to inject the dependencies
     */
    fun inject(userListViewModel: UserListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}