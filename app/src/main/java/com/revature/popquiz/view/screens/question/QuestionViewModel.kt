package com.revature.popquiz.view.screens.question

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.revature.popquiz.model.dataobjects.Answer
import com.revature.popquiz.model.dataobjects.Question
import com.revature.popquiz.model.dataobjects.Quiz

class QuestionViewModel: ViewModel() {

 var quiz= Quiz()
 var runningQuiz=RunningQuiz()
 var questionAnswer = mutableStateMapOf<Question,SnapshotStateList<Answer>>()

 fun clear()
 {
   runningQuiz=RunningQuiz()
   questionAnswer = mutableStateMapOf<Question,SnapshotStateList<Answer>>()

 }
}

class RunningQuiz
{
 var title=""
 var questions: List<Question> =listOf<Question>()
 val answers= listOf<Answer>()
 var progress=0
 //var oneAnswerQuestion = mutableStateMapOf<Question,SnapshotStateList<Answer>>()
 var oneAnswerQuestion = mutableMapOf<Question,MutableList<Answer>>()
 var score:Float =0F
 var maxScore:Float?=null
 var finalScore:Float?=null
}



