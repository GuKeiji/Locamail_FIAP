package br.com.fiap.locamail.screens

import android.content.ClipData.Item
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.locamail.components.CircleWithLetter
import br.com.fiap.locamail.components.DrawerItem
import coil.compose.AsyncImage

@Composable
fun DashboardScreen(navController: NavController) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val withAnim by animateDpAsState(targetValue = if (isExpanded) 200.dp else 0.dp)

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
                            text = "Dashboard",
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
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tempo diário lendo emails:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "4 horas",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Quantidade diária de emails recebidos:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "12 emails",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Quantidade diária de emails enviados:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "7 emails",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Sentimento passado nos emails:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    AsyncImage(
                        model = "https://lh4.googleusercontent.com/ySV2YcddxQAW_Piohw075djA6wQuqfFsh-_hV" +
                                "LE7mqPRC9ZTJry22CjByVcxoHbVYG4M8o5Yh9x7APzPVZEIN-XIzpRpNsDvHk6sqCGeFN8C6UyWvDeqmin6fmmrZnFSaiee7LA8",
                        contentDescription = "description",
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Cinza:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Neutros",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Laranja:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Negativos",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Azul:",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Positivos",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

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

