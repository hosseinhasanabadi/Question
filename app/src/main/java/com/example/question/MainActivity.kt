package com.example.question

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.question.screen.QuestionViewModel
import com.example.question.ui.theme.QuestionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                   TriviaHome()

                }
            }
        }
    }
}


@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()){
    Questions(viewModel)

}



@SuppressLint("SuspiciousIndentation")
@Composable
fun Questions(viewModel: QuestionViewModel) {

  val question = viewModel.data.value.data?.toMutableList()
    Log.d("SIZE","Question:${question?.size}")

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuestionTheme {

    }
}