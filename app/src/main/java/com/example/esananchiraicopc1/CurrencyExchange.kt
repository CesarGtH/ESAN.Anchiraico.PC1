package com.example.esananchiraicopc1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CurrencyExchange(navController: NavController){

    var amountInPen by remember { mutableStateOf("") }
    var amountInDol by remember { mutableStateOf("") }

    var Type by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val Types = listOf( "USD a PEN", "PEN a USD")
    var expanded by remember { mutableStateOf(false) }

    //Add column
    Column(
        modifier = Modifier.padding(32.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Calculadora de Tipo de Cambio", style = MaterialTheme.typography.titleLarge)
        TextField(
            value = amountInPen,
            onValueChange = {amountInPen = it},
            label = { Text("Monto") },
            modifier = Modifier.fillMaxWidth(),
            //Keyboard number
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text("Porcentaje de propina: ${percentage.toInt()}%")

        //Create Slider
        Slider(
            value = percentage,
            onValueChange = {percentage = it},
            valueRange = 0f..40f,
            steps = 5,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val amount = amountInPen.toDoubleOrNull() ?: 0.0
                val tip = amount * (percentage / 100)
                val totalAmount  = amount + tip
                result = "El Monto a pagar incluyendo la propina es: ${"%.2f".format(totalAmount)} soles."
            },
            modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Calcular")
        }
        if(result.isNotEmpty())
            Text(text = result)
    }


}