package com.example.noteapplication.ui.task

import androidx.lifecycle.MutableLiveData
import com.example.noteapplication.base.BaseEvent
import com.example.noteapplication.base.BaseViewModel
import com.example.noteapplication.base.NoteEvent
import com.example.noteapplication.data.model.Project
import com.example.noteapplication.data.model.Task
import com.example.noteapplication.data.network.ResponseResultStatus
import com.example.noteapplication.repository.TaskRepositoryImpl

class NotesListViewModel(
        private val repository: TaskRepositoryImpl
) : BaseViewModel<BaseEvent>() {

    val data: MutableLiveData<MutableList<Task>>? = MutableLiveData()
    var project: Project? = null

    var noteCreating = MutableLiveData<Boolean>()

    init {
        fetchAllProjectsTasks()
    }

    fun fetchAllProjectsTasks() {
        repository.fetchAllProjectsTasks(project?.id).observeForever {
            when (it.status) {
                ResponseResultStatus.ERROR -> message.value = it.message
                ResponseResultStatus.SUCCESS -> data?.value = it.result
            }
        }
    }

    fun createNote(text: String) {
        val data = Task(projectId = project?.id, content = text)
        repository.createNote(data).observeForever {
            when (it.status) {
                ResponseResultStatus.ERROR -> message.value = it.message
                ResponseResultStatus.SUCCESS -> {
                    if (it.result != null) {
                        message.value = "Заметка успешно создана"
                        event.value = NoteEvent.NoteCreated
                    } else {
                        message.value = "Ошибка при создании заметки"
                    }
                }
            }
        }
    }

    fun closeNote(id: Long?) {
        repository.closeNote(id).observeForever {
            when (it.status) {
                ResponseResultStatus.ERROR -> message.value = it.message
                ResponseResultStatus.SUCCESS -> event.value = NoteEvent.NoteClosed
            }
        }
    }
}




