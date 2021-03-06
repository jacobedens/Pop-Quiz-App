package com.revature.popquiz

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
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
import androidx.room.RoomDatabase
import com.revature.popquiz.model.room.RoomDataManager
import com.revature.popquiz.model.room.profileroom.ProfileRepository
import com.revature.popquiz.model.room.quizroom.QuizRepository
import com.revature.popquiz.service.AlarmReceiver
import com.revature.popquiz.service.INTENT_COMMAND
import com.revature.popquiz.service.INTENT_COMMAND_POPQUIZ
import com.revature.popquiz.ui.theme.PopQuizTheme
import com.revature.popquiz.view.navigation.StartNav
import com.revature.popquiz.viewmodels.QuizManager
import com.revature.popquiz.viewmodels.SplashScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity()
{

    //Will change with Dagger-Hilt? -Evan
    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val app = this



        CoroutineScope(Dispatchers.IO).launch {

            val quizRepository = QuizRepository(app.application)
            val profileRepository=ProfileRepository(app.application)
            RoomDataManager.quizRepository = quizRepository
            RoomDataManager.profileRepository=profileRepository

            QuizManager.loadQuizzes()
        }




        //Used to install and modify the Splash screen -Evan
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashScreenViewModel.isLoading.value
            }
        }

//        val intent = Intent(applicationContext, PopQuizActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//        if (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                pendingIntent.isActivity
//            } else {
//                TODO("VERSION.SDK_INT < S")
//            }
//        ) {
//            startActivity(intent)
//        }

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
//                    PopQuizSettingsScreen(navController = navController)
                    StartNav(navController = navController)
//                    Button(onClick = { createAlarm() }) {

                    }
                    //QuestionScreen()

                }
            }
        }
//    fun createAlarm() {
//        val intent = Intent(this, PopQuizActivity::class.java)
//        val flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//        val pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT)
//
//        val builder = NotificationCompat.Builder(this, POP_QUIZ_NOTIFICATION_CHANNEL)
//        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
//        builder.setContentTitle("Pop!Quiz")
//        builder.setContentText("Time for your Pop! Quiz")
//        builder.priority = NotificationCompat.PRIORITY_HIGH
//        builder.setContentIntent(pendingIntent)
//
//    }
}

