package br.com.fiap.locamail.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.components.CircleWithLetter
import br.com.fiap.locamail.components.DrawerItem

@Composable
fun ShowEmail(navController: NavController, title: String, content: String, sender: String) {
    val firstChar = sender.firstOrNull().toString();

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
                        tint = Color.White,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Color.Black)
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = title,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color(android.graphics.Color.parseColor("#0D0D0D")).copy(alpha = 0.8f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            CircleWithLetter(
                                letter = firstChar,
                                circleColor = Color(android.graphics.Color.parseColor("#fafafa")).copy(alpha = 0.8f),
                                textColor = Color.Gray,
                                size = 50
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = sender,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "Ontem",
                            color = Color.White
                        )
                    }
                    Divider(
                        color = Color.Gray,
                        thickness = 3.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Text(
                            text = content,
                            color = Color.White
                        )
                    }
                }
            }
        }
    })

}