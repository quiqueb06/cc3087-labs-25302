package com.uvg.lab5.data

import com.uvg.lab5.model.Articulo

val articulosDeEjemplo: List<Articulo> = listOf(
    Articulo(
        autor = "Marcela Fuentes",
        titulo = "Tu build tarda cuatro minutos y nadie sabe por qué",
        extracto = "Las tareas que corren de más cada vez que compilas y cómo encontrarlas.",
        minutosLectura = 6,
        fecha = "14 nov"
    ),
    Articulo(
        autor = "Rodrigo Estrada",
        titulo = "Dejé de escribir comentarios y el código mejoró",
        extracto = "Cuándo un comentario está tapando un nombre de variable mal escogido.",
        minutosLectura = 7,
        fecha = "8 nov"
    ),
    Articulo(
        autor = "Valeria Cifuentes",
        titulo = "Migramos el proyecto a Kotlin sin detenerlo",
        extracto = "Lo que aprendimos moviendo módulo por módulo durante seis meses.",
        minutosLectura = 5,
        fecha = "2 nov"
    )
)