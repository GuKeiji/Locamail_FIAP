package br.com.fiap.locamail.screens

import android.content.ClipData.Item
import android.widget.CalendarView
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import br.com.fiap.locamail.components.CircleWithLetter
import br.com.fiap.locamail.components.DrawerItem
import coil.compose.AsyncImage

@Composable
fun CalendarScreen(navController: NavController) {
    var date by remember {
        mutableStateOf("")
    }
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
                            text = "Calendário",
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AndroidView(
                        modifier = Modifier
                            .background(color = Color.White),
                        factory = { CalendarView(it) },
                        update = {
                        it.setOnDateChangeListener { calendarView, year, month, day -> date = "$day - ${month + 1} - $year" }
                    })
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

