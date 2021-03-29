package com.example.noteapp.repository

import com.example.noteapp.data.model.Project
import com.example.noteapp.data.network.RequestResult
import com.example.noteapp.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Headers

class ProjectRepository(var callback: RequestResult) {

    val api = RetrofitClient().projectApi

    fun fetchProjects() {
        api.fetchProjects().enqueue(object : Callback<MutableList<Project>> {
            override fun onFailure(call: Call<MutableList<Project>>, t: Throwable) {
                callback.onFailure(t)
            }

            override fun onResponse(call: Call<MutableList<Project>>, response: Response<MutableList<Project>>) {
                callback.onSuccess(response.body())
            }
        })
    }
}
