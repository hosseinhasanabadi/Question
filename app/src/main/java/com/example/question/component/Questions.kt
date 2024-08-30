package com.example.question.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.question.model.QuestionItem
import com.example.question.screen.QuestionViewModel
import com.example.question.util.AppColors

@SuppressLint("SuspiciousIndentation")
@Composable
fun Questions(viewModel: QuestionViewModel) {

    val question = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true){
        CircularProgressIndicator()
        Log.d("loading","Question:...loading")
    }else{
        Log.d("loading","Question:...loading stopped...")
        question?.forEach{questionitem->

            Log.d("Result","Question:${questionitem.question}")
        }
    }

}

@Composable
fun QuestionDisplay(
    question: QuestionItem,
    questionIndex:MutableState<Int>,
    viewModel: QuestionViewModel,
    onNextClicked:(Int)-> Unit
){
    val choicesState = remember(question) {
        question.choices.toMutableList()
    }
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
    Surface (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(4.dp),
        color = AppColors.mDarkPurple){
        Column(modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            QuestionTracker()
            DrawDottedLin(pathEffect)
            Column {
                Text(text = "what's the meaning of all this ",
                    modifier = Modifier
                        .padding(6.dp)
                        .align(
                            alignment = Alignment.Start
                        )
                        .fillMaxHeight(0.3f),
                    fontSize = 17.sp,
                    color = AppColors.mOffWhite,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp)
                //choices
                choicesState.forEachIndexed { index, answerText ->
                    Row (modifier = Modifier.padding(3.dp).
                    fillMaxWidth().
                    height(45.dp).fillMaxWidth()
                        .border(width = 4.dp, brush = Brush.linearGradient(
                            colors = listOf(AppColors.mDarkPurple
                                ,AppColors.mDarkPurple
                            )), shape = RoundedCornerShape(
                                15.dp
                            )
                        ).clip(RoundedCornerShape( 50.dp))
                        .background(Color.Transparent)){

                    }
                }

            }


        }


    }

}

@Composable
fun  DrawDottedLin(pathEffect: PathEffect){
  androidx.compose.foundation.Canvas( modifier = Modifier
      .fillMaxWidth()
      .height(1.dp)) {
      drawLine(color = AppColors.mLightGray,
          start = Offset(0f,0f)
          , end = Offset(size.width,0f),
          pathEffect= pathEffect
          )

  }

}








@Preview
@Composable
fun QuestionTracker(counter :Int = 10,
                    outOf:Int=100){
    Text(text = buildAnnotatedString {
        withStyle(style= ParagraphStyle(textIndent = TextIndent.None)){
            withStyle(style = SpanStyle(color = AppColors.mLightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )){
                append("Question $counter/")
                withStyle(style = SpanStyle(color = AppColors.mLightGray,
                    fontWeight = FontWeight.Light,
                    fontSize =14.sp )){
                    append("$outOf")
                }
            }
        }

    }, modifier = Modifier.padding(20.dp))

}
