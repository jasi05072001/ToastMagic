package com.jasmeet.customtoast.utils

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jasmeet.customtoast.R
import com.jasmeet.customtoast.main.ToastMagic

object Utils {

    @Composable
    fun SetView(
        messageTxt: String,
        resourceIcon: Painter? = null,
        backgroundColor: Color = Color.Black.copy(alpha = 0.2f),
        padding: PaddingValues,
        contentAlignment: Alignment,
        shape: Shape,
        textColor: Color = Color.White,
        iconColor: Color = Color.White,
        fontFamily: FontFamily = poppins,
        textSize :TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Normal

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = contentAlignment
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentSize(),
                color = Color.Transparent
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = backgroundColor,
                            shape = shape
                        )
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if (resourceIcon != null){
                        Image(
                            modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                            painter = resourceIcon,
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(iconColor)
                        )
                    }
                    Text(
                        text = messageTxt,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        style = TextStyle(
                            color = textColor,
                            fontFamily = fontFamily,
                            fontSize = textSize,
                            fontWeight = fontWeight

                        ),
                        modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun CustomToast(
        message: String,
        duration: Int = Toast.LENGTH_LONG,
        padding: PaddingValues = PaddingValues(0.dp),
        backgroundColor: Color = Color.Black.copy(alpha = 0.2f),
        shape: Shape = MaterialTheme.shapes.medium,
        icon: Painter? = null,
        textColor: Color = Color.White,
        iconColor: Color = Color.White,
        fontFamily: FontFamily = poppins,
        textSize :TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        val customToast = ToastMagic(LocalContext.current)
        customToast.MakeText(
            backgroundColor = backgroundColor,
            message = message,
            padding = padding,
            contentAlignment = Alignment.BottomCenter,
            duration = duration,
            shape = shape,
            icon = icon,
            textSize = textSize,
            textColor =  textColor,
            iconColor = iconColor,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        )
        customToast.show()
    }


}


private  val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)


val poppins = FontFamily(
    Font(
        googleFont = GoogleFont("Poppins"),
        fontProvider = provider,
    )
)
