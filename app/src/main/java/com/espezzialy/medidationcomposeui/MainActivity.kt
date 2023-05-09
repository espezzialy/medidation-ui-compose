package com.espezzialy.medidationcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.espezzialy.medidationcomposeui.ui.model.Feature
import com.espezzialy.medidationcomposeui.ui.theme.LightGreen1
import com.espezzialy.medidationcomposeui.ui.theme.LightGreen2
import com.espezzialy.medidationcomposeui.ui.theme.LightGreen3
import com.espezzialy.medidationcomposeui.ui.theme.MedidationComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedidationComposeUITheme {
//                HomeScreen()
                FeatureScreen(
                    Feature(
                    title = "Tips for sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                )
                )

            }
        }
    }
}
