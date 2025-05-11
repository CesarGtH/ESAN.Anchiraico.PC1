package com.example.esananchiraicopc1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "PetAgeCalculator"){
        composable("PetAgeCalculator") { 
            DrawerScaffold(navController) {
                CalculatorPetAge()
            } 

        composable("Currency") { CurrencyExchange(navController) }
        composable("home") {
            DrawerScaffold(navController) {
                HomeScreen()
            }
        }
        composable("gallery") {
            DrawerScaffold(navController) {
                GalleryPermissionScreen()
            }
        }
        composable("favorites") {
            DrawerScaffold(navController) {
                //TODO: Add favorites screen
                Text("Favorites (Screen)")
            }
        }
    }

}