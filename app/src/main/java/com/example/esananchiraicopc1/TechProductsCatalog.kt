package com.example.esananchiraicopc1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Add data countries
data class Product(val name: String, val precio: Double,val categoria: String, val item: String)

//add mock data
val mockProducts = listOf(
    Product("iPhone 15", 1200.0, "Celulares", "https://cdn.shopify.com/s/files/1/0057/3728/2621/products/iphone-15-pro-max-titanio-natural-),
    Product("Samsung Galaxy S24", 1000.0, "Celulares", "https://www.samsung.com/global/galaxy/galaxy-s24/images/galaxy-s24-ultra-midnight-galaxy-s24-ultra-midnight-front-midnight
)

@Composable
fun TechProductsCatalog(){

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text("Ranking FIFA", style =  MaterialTheme.typography.titleLarge)

        LazyColumn {
            items(mockCountries){country ->
                //TODO: Add Card and Text with countries
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
                {
                    Row(modifier = Modifier.padding(12.dp)){
                        Image(
                            painter = rememberAsyncImagePainter(country.flag),
                            contentDescription = country.name,
                            modifier = Modifier.size(64.dp),
                            //contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.padding(end = 16.dp))
                        Column() {
                            Text(text = country.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = country.ranking.toString(), style = MaterialTheme.typography.titleSmall)
                        }

                    }
                }
            }
}