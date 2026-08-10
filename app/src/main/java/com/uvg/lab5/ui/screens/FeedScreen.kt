package com.uvg.lab5.ui.screens

/*
 * Laboratorio 5 - Ruta B
 *
 * 1. ¿Qué pasa si le quito el weight a la Column del artículo?
 * Al quitarle el weight, la Column deja de repartirse el espacio sobrante y pasa a medir
 * solo lo que necesita su contenido. Como los títulos son largos, la fila crece más allá del
 * ancho de la pantalla y la miniatura de la derecha se sale del borde o queda cortada.
 * Con weight(1f) la columna recibe lo que queda después de reservar los 80.dp de la miniatura,
 * así que el texto se acomoda y la miniatura conserva su tamaño.
 *
 * 2. ¿Por qué el componente de artículo recibe un Modifier en lugar de fijar su margen adentro?
 * Porque el margen es decisión de quien coloca el componente, no del componente mismo. Si el
 * padding estuviera escrito adentro, el artículo se vería igual en todas partes y para usarlo
 * en otra pantalla con espaciados distintos tendría que editarlo o hacer una copia.
 * Recibiendo el Modifier, la misma pieza sirve con 16.dp aquí y con otro valor en la siguiente
 * pantalla sin tocar su código.
 *
 * Declaración de uso de IA: usé Claude para apoyarme en la construcción de esta pantalla.
 * Entiendo el código y puedo explicar cada decisión.
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.lab5.data.articulosDeEjemplo
import com.uvg.lab5.model.Articulo
import com.uvg.lab5.ui.components.ArticuloItem
import com.uvg.lab5.ui.components.BarraSuperior
import com.uvg.lab5.ui.components.FilaPestanas
import com.uvg.lab5.ui.components.Separador
import com.uvg.lab5.ui.theme.Lab5Theme

private val coloresAvatar = listOf(
    Color(0xFF3B5BA5),
    Color(0xFF8A4FAF),
    Color(0xFF2E7D5B)
)

private val coloresMiniatura = listOf(
    Color(0xFFC8D3EA),
    Color(0xFFDDCBEA),
    Color(0xFFC6E0D3)
)

@Composable
fun FeedScreen(
    articulos: List<Articulo>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        BarraSuperior(
            nombrePublicacion = "Compilado",
            inicial = "C",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Separador()
        FilaPestanas(
            pestanas = listOf("Para ti", "Siguiendo", "Destacados"),
            pestanaActiva = "Para ti",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )
        Separador()
        articulos.forEachIndexed { indice, articulo ->
            ArticuloItem(
                articulo = articulo,
                colorAvatar = coloresAvatar[indice % coloresAvatar.size],
                colorMiniatura = coloresMiniatura[indice % coloresMiniatura.size],
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
            Separador()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedScreenPreview() {
    Lab5Theme {
        FeedScreen(articulos = articulosDeEjemplo)
    }
}