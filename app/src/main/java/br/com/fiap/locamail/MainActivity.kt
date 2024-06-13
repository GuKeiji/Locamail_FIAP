package br.com.fiap.locamail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.locamail.screens.CreateFilterScreen
import br.com.fiap.locamail.screens.InitialScreen
import br.com.fiap.locamail.screens.ShowEmail
import br.com.fiap.locamail.ui.theme.LocamailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocamailTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "caixa"){
                        composable(route = "caixa"){
                            InitialScreen(navController)
                        }
                        composable(route = "criar"){
                            CreateFilterScreen(navController)
                        }
                        composable(
                            route = "email/{title}/{content}/{sender}",
                            arguments = listOf(
                                navArgument("title") { type = NavType.StringType },
                                navArgument("content") { type = NavType.StringType },
                                navArgument("sender") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val title = backStackEntry.arguments?.getString("title") ?: ""
                            val content = backStackEntry.arguments?.getString("content") ?: ""
                            val sender = backStackEntry.arguments?.getString("sender") ?: ""
                            ShowEmail(navController, title, content, sender)
                        }
                    }

                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LocamailTheme {
//        Greeting("Android")
//    }
//}