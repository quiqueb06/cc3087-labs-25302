package com.uvg.lab5.ui.screens

/*
 * Declaración de uso de IA: usé Claude (Anthropic) como apoyo para construir esta
 * pantalla a partir del enunciado. Revisé el código, ejecuté los experimentos en el
 * emulador y puedo explicar cada decisión.
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.lab5.data.sampleArticles
import com.uvg.lab5.model.Article
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
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    // Estado de interfaz: se conserva cuando Android recrea la Activity al rotar.
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }
    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }

    // Prueba C: rememberSaveable + mutableStateOf.
    var applauseCount by rememberSaveable { mutableStateOf(0) }

    // Lista derivada: se recalcula desde la lista original y los filtros activos.
    val visibleArticles = articles.filter { article ->
        val matchesSearch = searchQuery.isBlank() ||
                article.title.contains(searchQuery, ignoreCase = true) ||
                article.author.contains(searchQuery, ignoreCase = true)
        val matchesShortReads = !showShortReadsOnly || article.readingMinutes <= 5
        val matchesTab = when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        matchesSearch && matchesShortReads && matchesTab
    }
    val resultCount = visibleArticles.size

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
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )
        Separador()
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Buscar por título o autor") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    checked = showShortReadsOnly,
                    onCheckedChange = { showShortReadsOnly = it }
                )
                Text(
                    text = "Solo lecturas cortas",
                    fontSize = 14.sp,
                    color = Color(0xFF242424)
                )
            }
            Text(
                text = if (resultCount == 1) "1 resultado" else "$resultCount resultados",
                fontSize = 12.sp,
                color = Color(0xFF6B6B6B)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { applauseCount++ }) {
                Text(
                    text = "Aplaudir · $applauseCount",
                    fontSize = 14.sp
                )
            }
        }
        Separador()
        if (visibleArticles.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "No se encontraron artículos",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF242424)
                )
                Text(
                    text = "Cambia la pestaña, la búsqueda o el filtro.",
                    fontSize = 14.sp,
                    color = Color(0xFF6B6B6B)
                )
            }
        } else {
            visibleArticles.forEachIndexed { indice, article ->
                ArticuloItem(
                    article = article,
                    colorAvatar = coloresAvatar[indice % coloresAvatar.size],
                    colorMiniatura = coloresMiniatura[indice % coloresMiniatura.size],
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
                Separador()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FeedScreenPreview() {
    Lab5Theme {
        FeedScreen(articles = sampleArticles)
    }
}