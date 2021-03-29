package com.example.noteapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//{
//    "id": 4578618606,
//    "assigner": 0,
//    "project_id": 2258325417,
//    "section_id": 0,
//    "order": 1,
//    "content": "Уроки по программированию",
//    "completed": false,
//    "label_ids": [],
//    "priority": 1,
//    "comment_count": 0,
//    "creator": 30388905,
//    "created": "2021-02-14T05:53:09Z",
//    "url": "https://todoist.com/showTask?id=4578618606"
//}

//Int = 0
//Boolean = false
//String = "Сообщение"
//Long = 0L
//Double = 0.0
//@Entity(tableName = "Task")
//data class Task(
//    @PrimaryKey(autoGenerate = false)
//    val id: Long? = null,
//    val assigner: Int? = null,
//    val project_id: Long? = null,
//    val order: Int? = null,
//    val content: String? = null,
//    val completed: Boolean? = null,
//    val priority: Int? = null,
//    val comment_count: Int? = null,
//    val creator: Long? = null,
//    val created: Int? = null
//)

data class Task (
        val id: Long? = null,
        val assigner: Int? = null,
        @SerializedName("project_id")
        val projectId: Long? = null,
        @SerializedName("section_id")
        val sectionId: Int? = null,
        val order: Int? = null,
        val content: String? = null,
        val completed: Boolean? = null,
        @SerializedName("label_ids")
        val labelIds: MutableList<Int>,
        val priority: Int? = null,
        @SerializedName("comment_count")
        val commentCount: Int? = null,
        val creator: Int? = null,
        val created: String? = null,
        val url: String? = null
)
