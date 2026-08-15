package com.uvg.lab5.data

import com.uvg.lab5.model.Article

val sampleArticles: List<Article> = listOf(
    Article(
        author = "Marcela Fuentes",
        title = "Tu build tarda cuatro minutos y nadie sabe por qué",
        excerpt = "Las tareas que corren de más cada vez que compilas y cómo encontrarlas.",
        readingMinutes = 6,
        date = "14 nov",
        isAuthorFollowed = true,
        isFeatured = false
    ),
    Article(
        author = "Rodrigo Estrada",
        title = "Dejé de escribir comentarios y el código mejoró",
        excerpt = "Cuándo un comentario está tapando un nombre de variable mal escogido.",
        readingMinutes = 7,
        date = "8 nov",
        isAuthorFollowed = false,
        isFeatured = true
    ),
    Article(
        author = "Valeria Cifuentes",
        title = "Migramos el proyecto a Kotlin sin detenerlo",
        excerpt = "Lo que aprendimos moviendo módulo por módulo durante seis meses.",
        readingMinutes = 5,
        date = "2 nov",
        isAuthorFollowed = true,
        isFeatured = true
    )
)