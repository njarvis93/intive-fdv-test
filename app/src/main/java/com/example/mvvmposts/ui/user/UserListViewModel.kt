package com.example.mvvmposts.ui.user

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.mvvmposts.R
import com.example.mvvmposts.base.BaseViewModel
import com.example.mvvmposts.model.User
import com.example.mvvmposts.network.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListViewModel:BaseViewModel() {
    @Inject
    lateinit var userApi: UserApi

    private lateinit var subscription: Disposable

    val userListAdapter: UserListAdapter = UserListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadUsers() }

    init{
        loadUsers()
    }

    private fun loadUsers(){
        subscription = userApi.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveUserListStart() }
            .doOnTerminate { onRetrieveUserListFinish() }
            .subscribe(
                { result -> onRetrieveUserListSuccess(result.results) },
                { error -> onRetrieveUserListError(error) }
            )
    }

    private fun onRetrieveUserListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveUserListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUserListSuccess(userList:List<User>){
        userListAdapter.updateUserList(userList)
    }

    private fun onRetrieveUserListError(error:Throwable){
        Log.e("fail", error.message+" "+error.toString())
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}