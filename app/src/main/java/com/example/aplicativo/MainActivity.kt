package com.example.aplicativo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicativo.ui.theme.AplicativoTheme
import com.example.aplicativo.ui.theme.DebugButtonColors
import com.example.aplicativo.ui.theme.ErrorButtonColors
import com.example.aplicativo.ui.theme.InfoButtonColors
import com.example.aplicativo.ui.theme.WarningButtonColors
import com.example.aplicativo.ui.theme.composable.StyledTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicativoTheme {
                App()
            }
        }
    }
}
@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(){
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "My test",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                )
            }


            Greeting("Atividade de PAM II")

            StyledTextField()

            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){

                Log.d(TAG, "Nota MB")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "Nota B")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(TAG, "Nota R")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                try {
                    throw RuntimeException("")
                }catch(ex: Exception){
                    Log.e(TAG, "Nota I")
                }
            }
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewDebug(){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton(
            text = "Debug",
            buttonColors = DebugButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {

            Log.d(TAG, "Nota MB")
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewInfo(){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton(
            text = "Info",
            buttonColors = InfoButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.i(TAG, "Nota B")
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewWarning(){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton(
            text = "Warning",
            buttonColors = WarningButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ){
            Log.w(TAG, "Nota R")
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewError(){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton(
            text = "Error",
            buttonColors = ErrorButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ){
            try {
                throw RuntimeException("")
            }catch(ex: Exception){
                Log.e(TAG, "Nota I")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun AppPreview(){
    AplicativoTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplicativoTheme {
        Greeting("Atividade de PAM II")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Atividade de PAM II!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}