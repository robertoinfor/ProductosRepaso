package com.example.productosejemplo.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Title(name: String){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
}

@Composable
fun ActionButton(){
    FloatingActionButton(
        onClick = {/*TODO*/},
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )
    }
}

@Composable
fun MainIconButton(icon: ImageVector, onClick:() -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}