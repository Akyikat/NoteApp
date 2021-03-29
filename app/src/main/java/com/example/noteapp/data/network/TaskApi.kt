package com.example.noteapp.data.network

import androidx.room.Dao
import com.example.noteapp.data.model.Project
import com.example.noteapp.data.model.Task
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface TaskApi {
    @Headers(
            "Authorization: Bearer 18d41187422aa8a8949e8a12f437b961c34b0dce",
            "client_id: e71d58b4ed1b48abb2b8530df55be03f",
            "client_secret: 324fa28e17164dc8b799b373f3480806"
    )

    @GET("tasks")
    fun fetchTasks(@Query("project_id") id: Long?): Call<MutableList<Project>>
}
