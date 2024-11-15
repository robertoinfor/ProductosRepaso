package com.example.productosejemplo.views

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.productosejemplo.ui.theme.components.ActionButton
import com.example.productosejemplo.ui.theme.components.MainIconButton
import com.example.productosejemplo.ui.theme.components.Title
import com.example.productosejemplo.ui.theme.data.Producto
import com.example.productosejemplo.ui.theme.data.Productos

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainProductos(navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Title(name = "Lista de productos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        },
    ){
    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        .padding(horizontal = 5.dp)) {
        items(Productos.products) {
            producto -> ItemsProducto(navController, producto = producto, producto.nombre, producto.precio)
        }
    }
    }
}

@Composable
fun ItemsProducto(navController: NavController, producto: Producto, nombre: String, precio:Double) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
        .padding(horizontal = 5.dp)
        .border(1.dp, color = Color.Red, shape = RectangleShape)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 5.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth() // Hace que el Row ocupe todo el ancho disponible
                    .padding(start = 0.dp, end = 0.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(producto.nombre + " ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 0.dp, end = 0.dp))
            }
            Row {
                Text(producto.precio.toString(),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 0.dp, end = 0.dp))
            }
        }
        Column(
            modifier = Modifier
                .weight(1f) // Toma el 50% del ancho disponible
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 5.dp)
        ) {
            Button(onClick = { navController.navigate("Detalle/${nombre}") }) {
                Text("Detalles de ${nombre}")
            }
        }
    }
}
