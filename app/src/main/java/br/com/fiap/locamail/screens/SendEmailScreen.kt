package br.com.fiap.locamail.screens

import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import br.com.fiap.locamail.components.DrawerItem

@Composable
fun SendEmailScreen(navController: NavController) {
    var subject by remember { mutableStateOf("") }
    var body by remember { mutableStateOf(TextFieldValue("")) }
    var recipientEmail by remember { mutableStateOf("") } // Campo para o email do destinatário

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
                            text = "Enviar Email",
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0x21212121)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        // Campo de assunto
                        BasicTextField(
                            value = subject,
                            onValueChange = { subject = it },
                            decorationBox = { innerTextField ->
                                if (subject.isEmpty()) {
                                    Text("Assunto", color = Color.Gray)
                                }
                                innerTextField()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .background(Color.White, shape = MaterialTheme.shapes.small)
                                .padding(16.dp)
                        )

                        // Campo de corpo do email
                        BasicTextField(
                            value = body,
                            onValueChange = { body = it },
                            decorationBox = { innerTextField ->
                                if (body.text.isEmpty()) {
                                    Text("Escreva seu email aqui...", color = Color.Gray)
                                }
                                innerTextField()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(vertical = 8.dp)
                                .background(Color.White, shape = MaterialTheme.shapes.small)
                                .padding(16.dp)
                        )

                        // Campo de destinatário (entrada manual)
                        BasicTextField(
                            value = recipientEmail,
                            onValueChange = { recipientEmail = it },
                            decorationBox = { innerTextField ->
                                if (recipientEmail.isEmpty()) {
                                    Text("Destinatário (email)", color = Color.Gray)
                                }
                                innerTextField()
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .background(Color.White, shape = MaterialTheme.shapes.small)
                                .padding(16.dp)
                        )

                        // Botão de envio
                        Button(
                            onClick = {
                                sendEmail(subject, body.text, recipientEmail)
                                navController.navigate("caixa")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            Text(text = "Enviar")
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

fun sendEmail(subject: String, body: String, recipientEmail: String) {
    // Simula a lógica de envio do email
    // Aqui é onde você conectaria a lógica do banco de dados para enviar o email
    // Isso pode ser feito através de uma chamada a um servidor ou persistência local

    println("Assunto: $subject")
    println("Corpo: $body")
    println("Destinatário: $recipientEmail")
}

