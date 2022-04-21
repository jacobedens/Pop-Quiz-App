package com.revature.popquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.revature.popquiz.model.room.quizroom.QuizRepository
import com.revature.popquiz.model.room.RoomDataManager
import com.revature.popquiz.model.room.answerroom.AnswerRepository
import com.revature.popquiz.model.room.questionroom.QuestionRepository
import com.revature.popquiz.ui.theme.PopQuizTheme
import com.revature.popquiz.view.navigation.StartNav
import com.revature.popquiz.viewmodels.QuizManager

import com.revature.popquiz.viewmodels.SplashScreenViewModel
//import dagger.hilt.android.AndroidEntryPoint
//
//
//@AndroidEntryPoint
class MainActivity : ComponentActivity()
{

    //Will change with Dagger-Hilt? -Evan
    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val quizRepository= QuizRepository(this.application)
        val questionRepository = QuestionRepository(this.application)
        val answerRepository=AnswerRepository(this.application)
        RoomDataManager.quizRepository=quizRepository
        RoomDataManager.questionRepository=questionRepository
        RoomDataManager.answerRepository=answerRepository
        QuizManager.loadQuizzes()




        //Used to install and modify the Splash screen -Evan
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashScreenViewModel.isLoading.value
            }
        }

        setContent {


            //Create the navigation controller
            val navController = rememberNavController()


            PopQuizTheme()
            {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    //Navigation Start
                    StartNav(navController = navController)
                    //QuestionScreen()

                }
            }
        }
    }
}