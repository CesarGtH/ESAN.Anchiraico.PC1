package com.example.esananchiraicopc1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
fun CalculatorPetAge(navController: NavController){

    var DogAge by remember { mutableStateOf("") }
    var DogSize by remember { mutableStateOf("Pequeño") }
    var result by remember { mutableStateOf("") }
    val DogSizes = listOf( "Pequeño", "Mediano", "Grande")
    var expanded by remember { mutableStateOf(false) }

        //Add column
        Column(
            modifier = Modifier.padding(32.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Calculadora de Edad Canina", style = MaterialTheme.typography.titleLarge)
            TextField(
                value = DogAge,
                onValueChange = {DogAge = it},
                label = { Text("Edad del perro") },
                modifier = Modifier.fillMaxWidth(),
                //Keyboard number
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            /*Text("Porcentaje de propina: ${percentage.toInt()}%")

            //Create Slider
            Slider(
                value = percentage,
                onValueChange = {percentage = it},
                valueRange = 0f..40f,
                steps = 5,
                modifier = Modifier.fillMaxWidth()
            )*/
            Text("Actividad Física:")
            Box{
                OutlinedButton(
                    onClick = { expanded = true },
                ) {
                    Text(DogSize)
                }
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false })
                {
                    DogSizes.forEach { sizeOption ->
                        DropdownMenuItem(
                            text = { Text(text = sizeOption) },
                            onClick = {
                                DogSize = sizeOption
                                expanded = false
                            }
                        )
                    }
                }

            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val edadHumana = DogAge.toIntOrNull() ?: 0
                    val edadPerro = when{
                        DogSize == "Pequeño" -> edadHumana * 5
                        DogSize == "Mediano" -> edadHumana * 6
                        DogSize == "Grande" -> edadHumana * 7
                        else -> {}
                    }
                    result = "La edad equivalente del perro es: ${edadPerro} años."
                }
            )
            {
                Text("Calcular Edad de Perro")
            }
            if(result.isNotEmpty())
                Text(result, style = MaterialTheme.typography.titleMedium)
        }
}
