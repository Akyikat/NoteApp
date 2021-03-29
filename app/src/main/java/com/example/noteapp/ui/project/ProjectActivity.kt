package com.example.noteapp.ui.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.data.model.Project
import com.example.noteapp.data.network.RequestResult
import com.example.noteapp.repository.ProjectRepository
import com.example.noteapp.ui.task.TaskListActivity
import kotlinx.android.synthetic.main.activity_main.*

class ProjectActivity : AppCompatActivity(), RequestResult, ProjectAdapter.ClickListener {

    private lateinit var adapter: ProjectAdapter
    private lateinit var repository: ProjectRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupRepository()
        fetchData()
    }

    private fun setupRecyclerView() {
        adapter = ProjectAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }

    private fun setupRepository() {
        repository = ProjectRepository(this)
    }

    private fun fetchData() {
        repository.fetchProjects()
    }

    override fun <T> onSuccess(result: T) {
        val data = result as MutableList<Project>
        adapter.addItems(data)
    }

    override fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(item: Project) {
        val intent = Intent(this, TaskListActivity::class.java)
        intent.putExtra(PROJECT_KEY, item)
        startActivity(intent)
    }

    companion object {
        const val PROJECT_KEY = "PROJECT_KEY"
    }

}