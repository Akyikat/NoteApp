package com.example.noteapp.repository

import com.example.noteapp.data.model.Project
import com.example.noteapp.data.network.RequestResult
import com.example.noteapp.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TaskRepository(var callback: RequestResult) {

    val api = RetrofitClient().taskApi

    fun fetchAllProjectsTasks(id: Long?) {
        api.fetchTasks(id).enqueue(object : Callback<MutableList<Project>> {
            override fun onFailure(call: Call<MutableList<Project>>, t: Throwable) {
                callback.onFailure(t)
            }

            override fun onResponse(call: Call<MutableList<Project>>, response: Response<MutableList<Project>>) {
                if (response.isSuccessful) callback.onSuccess(response.body())
                else callback.onFailure(Throwable("error"))
            }
        })
    }

}