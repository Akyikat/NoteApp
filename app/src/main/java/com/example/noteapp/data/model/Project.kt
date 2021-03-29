package com.example.noteapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//{
//  "id": 2259623414,
//"color": 48,
//"name": "Inbox",
//"comment_count": 0,
//"shared": false,
//"favorite": false,
//"sync_id": 0,
//"inbox_project": true
//}

data class Project (
    var id: Long? = null,
    var color: Int? = null,
    var name: String? = null,
    @SerializedName("comment_count")
    var commentCount: Int? = null,
    @SerializedName("sync_id")
    var syncId: Int? = null,
    @SerializedName("inbox_project")
    var inboxProject: Boolean? = null
) : Serializable
