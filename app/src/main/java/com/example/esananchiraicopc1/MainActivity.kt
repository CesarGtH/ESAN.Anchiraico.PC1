package com.example.esananchiraicopc1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.esananchiraicopc1.ui.theme.ESANAnchiraicoPC1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ESANAnchiraicoPC1Theme {
                //botones para dirigir a las otras pantallas
                Button(onClick = { rememberNavController().navigate("PetAgeCalculator") }) {
                    Text("Calculadora de Edad Canina")
                }
                Button(onClick = { navController.navigate("Currency") }) {
                    Text("Calculadora de Tipo de Cambio")

                }
            }
        }
    }
}