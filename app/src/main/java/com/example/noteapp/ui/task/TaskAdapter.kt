package com.example.noteapp.ui.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(private var listener: ClickListener) : RecyclerView.Adapter<TasksViewHolder>() {

    private var items = mutableListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        return TasksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    fun addItems(data: MutableList<Task>) {
        items = data
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onItemClick(item: Task)
    }

}

class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Task) {
        itemView.tv_task.text = item.content
    }

}

//fun main() {
//    print(isPalindrom("dog", "adog"))
//
//}
//
//fun isPalindrom(input: String, compareWord: String): Boolean {
//
//    val compareWordAtCharArray = compareWord.toCharArray()
//    var isPalindrom = false
//      compareWordAtCharArray.forEach {
//        if (input.contains(it)) isPalindrom = true
//        else return false
//    }
//    return isPalindrom
//}
