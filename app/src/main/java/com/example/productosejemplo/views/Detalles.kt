package com.example.productosejemplo.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.productosejemplo.ui.theme.components.ActionButton
import com.example.productosejemplo.ui.theme.components.MainIconButton
import com.example.productosejemplo.ui.theme.components.Title

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalleMain(navController: NavController, nombre: String){
    Scaffold (
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Title(name = nombre) },
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
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(horizontal = 5.dp)
        ) {
            Text("hola ${nombre}")
        }
    }
}