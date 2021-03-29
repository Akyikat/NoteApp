package com.example.noteapp.data.network

import androidx.room.*
import com.example.noteapp.data.model.Task


//CRUD - CREATE READ UPDATE DELETE
//    @Insert - Post - Добавление
//    @Update - Put - Изменение
//    @Query - Произвольный запрос
//    @Delete - Delete - Удаление
@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublications(data: List<Task>?)

}