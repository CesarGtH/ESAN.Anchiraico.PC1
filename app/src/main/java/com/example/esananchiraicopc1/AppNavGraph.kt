package com.example.esananchiraicopc1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavGraph(){

    button(
        onClick = { navController.navigate("PetAgeCalculator") })


}