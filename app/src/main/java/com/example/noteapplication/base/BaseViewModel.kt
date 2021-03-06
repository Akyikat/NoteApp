package com.example.noteapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T: BaseEvent> : ViewModel() {
    val message = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    val event = MutableLiveData<T>()

}