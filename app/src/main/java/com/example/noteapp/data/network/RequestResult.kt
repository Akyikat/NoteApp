package com.example.noteapp.data.network


interface RequestResult {
    fun <T>onSuccess(result : T)
    fun onFailure(t: Throwable)
}
