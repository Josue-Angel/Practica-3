package com.example.practica3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun App() {
    // Variables para guardar lo que escribe el usuario
    var nombre by remember { mutableStateOf("") }
    var matricula by remember { mutableStateOf("") }
    var asignatura by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }


    // Variables para controlar si mostramos un error o la tarjeta
    var hayError by remember { mutableStateOf(false) }
    var mostrarTarjeta by remember { mutableStateOf(false) }


    // Variables espejo para congelar los datos al picarle al botón
    var nombreGuardado by remember { mutableStateOf("") }
    var matriculaGuardada by remember { mutableStateOf("") }
    var asignaturaGuardada by remember { mutableStateOf("") }
    var horaGuardada by remember { mutableStateOf("") }
    var fechaGuardada by remember { mutableStateOf("") }


    // Contenedor con scroll
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario de Registro")
        Spacer(modifier = Modifier.height(16.dp))


        // Campo Nombre
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo Matrícula
        TextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matrícula") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo Asignatura
        TextField(
            value = asignatura,
            onValueChange = { asignatura = it },
            label = { Text("Asignatura") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo Hora
        TextField(
            value = hora,
            onValueChange = { hora = it },
            label = { Text("Hora") }
        )
        Spacer(modifier = Modifier.height(8.dp))


        // Campo Fecha
        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha de entrega") }
        )
        Spacer(modifier = Modifier.height(16.dp))


        // Mensaje de error si falta algo
        if (hayError) {
            Text(text = "Por favor llena todos los campos correctamente")
            Spacer(modifier = Modifier.height(8.dp))
        }


        // Botón para Guardar
        Button(onClick = {
            // Validación: checar que ningún campo esté vacío
            if (nombre == "" || matricula == "" || asignatura == "" || hora == "" || fecha == "") {
                hayError = true
                mostrarTarjeta = false
            } else {
                hayError = false


                // Pasamos los datos para que se queden fijos en la tarjeta
                nombreGuardado = nombre
                matriculaGuardada = matricula
                asignaturaGuardada = asignatura
                horaGuardada = hora
                fechaGuardada = fecha


                mostrarTarjeta = true
            }
        }) {
            Text("Guardar")
        }


        Spacer(modifier = Modifier.height(16.dp))


        // Tarjeta que aparece abajo del botón con los datos
        if (mostrarTarjeta) {
            Card(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Datos Guardados:")
                    Text(text = "Nombre: $nombreGuardado")
                    Text(text = "Matrícula: $matriculaGuardada")
                    Text(text = "Asignatura: $asignaturaGuardada")
                    Text(text = "Hora: $horaGuardada")
                    Text(text = "Fecha: $fechaGuardada")
                }
            }
        }
    }
}
