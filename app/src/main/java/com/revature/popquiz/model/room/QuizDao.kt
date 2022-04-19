package com.revature.popquiz.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.revature.popquiz.model.dataobjects.QuizEntity

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    fun fetchAllQuiz(): LiveData<List<QuizEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: QuizEntity)
    @Query("DELETE FROM quiz WHERE id=:id")
    suspend fun deleteQuiz(id:Int)

}