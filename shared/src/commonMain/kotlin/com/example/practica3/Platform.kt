package com.example.practica3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform