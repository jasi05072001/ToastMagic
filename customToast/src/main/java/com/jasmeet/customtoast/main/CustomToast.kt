package com.jasmeet.customtoast.main

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.jasmeet.customtoast.utils.Utils
import com.jasmeet.customtoast.utils.poppins


class ToastMagic(context: Context) : Toast(context) {

    @Composable
    fun MakeText(
        backgroundColor: Color,
        message: String,
        duration: Int = LENGTH_LONG,
        padding: PaddingValues,
        contentAlignment: Alignment,
        icon: Painter? = null,
        shape: Shape = MaterialTheme.shapes.medium,
        textColor: Color = Color.White,
        iconColor: Color = Color.White,
        fontFamily: FontFamily = poppins,
        textSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        val context = LocalContext.current

        val views = ComposeView(context)
        views.apply {
            setContent {
                icon?.let { resourceIcon ->
                    Utils.SetView(
                        messageTxt = message,
                        backgroundColor = backgroundColor,
                        padding = padding,
                        contentAlignment = contentAlignment,
                        resourceIcon = resourceIcon,
                        shape = shape,
                        textSize = textSize,
                        textColor = textColor,
                        iconColor = iconColor,
                        fontWeight = fontWeight,
                        fontFamily = fontFamily
                    )
                } ?: run {
                    Utils.SetView(
                        messageTxt = message,
                        backgroundColor = backgroundColor,
                        padding = padding,
                        contentAlignment = contentAlignment,
                        shape = shape,
                        textSize = textSize,
                        textColor = textColor,
                        iconColor = iconColor,
                        fontWeight = fontWeight,
                        fontFamily = fontFamily
                    )
                }
            }
            setViewTreeLifecycleOwner(LocalLifecycleOwner.current)
            setViewTreeViewModelStoreOwner(LocalViewModelStoreOwner.current)
            setViewTreeSavedStateRegistryOwner(LocalSavedStateRegistryOwner.current)
        }

        this.duration = duration
        this.view = views
    }
}
