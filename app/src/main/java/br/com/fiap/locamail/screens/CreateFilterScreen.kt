package br.com.fiap.locamail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locamail.components.CircleWithLetter
import br.com.fiap.locamail.repository.FilterRepository
import kotlinx.coroutines.launch

@Composable
fun CreateFilterScreen(navController: NavController) {
    val context = LocalContext.current
    val filterRepository = FilterRepository.getInstance(context)
    val coroutineScope = rememberCoroutineScope()

    var nomeFiltro by remember { mutableStateOf("") };
    var filtrarKeywords by remember { mutableStateOf("") };

    Scaffold(content = { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Column(
                modifier = Modifier
                    .background(Color(android.graphics.Color.parseColor("#212121")).copy(alpha = 0.8f))
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        modifier = Modifier
                            .clickable { navController.navigate("caixa") },
                        contentDescription = "Icon de menu",
                        tint = androidx.compose.ui.graphics.Color.White,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Criar novo filtro"
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color(android.graphics.Color.parseColor("#0D0D0D")).copy(alpha = 0.8f)),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = nomeFiltro,
                        onValueChange = { nomeFiltro = it },
                        label = { Text("Nome filtro") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = filtrarKeywords,
                        onValueChange = { filtrarKeywords = it },
                        label = { Text("Filtrar keywords") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            if (nomeFiltro.isNotBlank() && filtrarKeywords.isNotBlank()) {
                                coroutineScope.launch {
                                    filterRepository.addFilter("$nomeFiltro: $filtrarKeywords")
                                }
                            }
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Criar")
                    }
                }
            }
        }
    })

}
