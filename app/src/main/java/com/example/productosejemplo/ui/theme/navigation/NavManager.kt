package com.example.productosejemplo.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.productosejemplo.views.DetalleMain
import com.example.productosejemplo.views.MainProductos

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            MainProductos(navController)
        }
        composable("Detalle/{nombre}", arguments = listOf(
            navArgument("nombre"){
                type = NavType.StringType
            }
        )) {
            val nombre =it.arguments?.getString("nombre")?:""
            DetalleMain(navController, nombre)
        }
    }
}