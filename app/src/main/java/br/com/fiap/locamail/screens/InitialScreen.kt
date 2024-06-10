package br.com.fiap.locamail.screens

import android.content.ClipData.Item
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.components.CircleWithLetter

@Composable
fun InitialScreen(navController: NavController) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val withAnim by animateDpAsState(targetValue = if(isExpanded) 200.dp else 0.dp)

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
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        modifier = Modifier.clickable { isExpanded = !isExpanded; },
                        contentDescription = "Icon de menu",
                        tint = Color.White
                    )
                    Row(
                        modifier = Modifier
                            .width(400.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Caixa de Entrada",
                            fontSize = 25.sp,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Icon de busca",
                            tint = Color.White
                        )
                    }


                }
                LazyColumn {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "A",
                                circleColor = Color.Blue,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "AliExpress")
                                Text(text = "Você ganhou FRETE GRÁTIS")
                                Text(text = "Promoção exclusiva para você")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "F",
                                circleColor = Color.Yellow,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "FIAP")
                                Text(text = "Nova forma de envio de boleto")
                                Text(text = "Você recebe seu boleto...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "U",
                                circleColor = Color.Red,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Uber")
                                Text(text = "Recibos da Uber")
                                Text(text = "Sua viagem de ontem à noite...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "S",
                                circleColor = Color.Cyan,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Shopee")
                                Text(text = "É HOJE 6.6 LIQUIDAÇÃO")
                                Text(text = "CELULARES E DISPOSITIVOS...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "A",
                                circleColor = Color.Blue,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "AliExpress")
                                Text(text = "Você ganhou FRETE GRÁTIS")
                                Text(text = "Promoção exclusiva para você")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "F",
                                circleColor = Color.Yellow,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "FIAP")
                                Text(text = "Nova forma de envio de boleto")
                                Text(text = "Você recebe seu boleto...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "U",
                                circleColor = Color.Red,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Uber")
                                Text(text = "Recibos da Uber")
                                Text(text = "Sua viagem de ontem à noite...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "S",
                                circleColor = Color.Cyan,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Shopee")
                                Text(text = "É HOJE 6.6 LIQUIDAÇÃO")
                                Text(text = "CELULARES E DISPOSITIVOS...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "A",
                                circleColor = Color.Blue,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "AliExpress")
                                Text(text = "Você ganhou FRETE GRÁTIS")
                                Text(text = "Promoção exclusiva para você")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "F",
                                circleColor = Color.Yellow,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "FIAP")
                                Text(text = "Nova forma de envio de boleto")
                                Text(text = "Você recebe seu boleto...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "U",
                                circleColor = Color.Red,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Uber")
                                Text(text = "Recibos da Uber")
                                Text(text = "Sua viagem de ontem à noite...")
                            }
                            Text(text = "Ontem")
                        }
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        )
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(color = Color.Black),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround

                        ) {
                            CircleWithLetter(
                                letter = "S",
                                circleColor = Color.Cyan,
                                textColor = Color.Gray,
                                size = 70
                            )
                            Column(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 200.dp)
                            ) {
                                Text(text = "Shopee")
                                Text(text = "É HOJE 6.6 LIQUIDAÇÃO")
                                Text(text = "CELULARES E DISPOSITIVOS...")
                            }
                            Text(text = "Ontem")
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(withAnim)
                    .background(Color(android.graphics.Color.parseColor("#212121")))
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    modifier = Modifier.clickable { isExpanded = !isExpanded; },
                    contentDescription = "Icon de menu",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                DrawerItem(Icons.Default.Email, "Caixa de Email", isExpanded, navController)
            }
        }
    })

}

@Composable
fun DrawerItem(icon: ImageVector, title: String, expanded: Boolean, navController: NavController) {
    if (expanded) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .clickable { navController.navigate("caixa") },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = "Icon de menu",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = title,
                color = Color.White
            )
        }
    }
}