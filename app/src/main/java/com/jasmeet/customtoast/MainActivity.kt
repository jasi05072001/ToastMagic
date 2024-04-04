package com.jasmeet.customtoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jasmeet.customtoast.ui.theme.CustomToastTheme
import com.jasmeet.customtoast.utils.Utils.CustomToast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomToastTheme {

                Greeting(
                    name = "Android",
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var show by remember {
        mutableStateOf(false)
    }
    var d by remember {
        mutableStateOf("")
    }
    if (show)
        CustomToast(
            message = "Hello $name",
            duration = Toast.LENGTH_SHORT,
            padding = PaddingValues(10.dp),
            shape = MaterialTheme.shapes.small,
            icon = painterResource(id = R.drawable.ic_android_black_24dp),
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            textColor = Color.Green,
            iconColor = Color.Green

        )


    Column ( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {
            show = true
        }) {
            Text(text = "Clik me")
        }
        Button(onClick = {
            show = false
        }) {
            Text(text = "Clik me")
        }

        TextField(value =d , onValueChange ={
            d = it
        } )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomToastTheme {
        Greeting("Android")
    }
}