package com.uvg.lab5.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.lab5.model.Article

@Composable
fun ArticuloItem(
    article: Article,
    colorAvatar: Color,
    colorMiniatura: Color,
    modifier: Modifier = Modifier
) {
    // Row externo: texto a la izquierda, miniatura a la derecha.
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Row del autor: avatar circular y nombre.
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(colorAvatar)
                )
                Text(
                    text = article.author,
                    fontSize = 12.sp,
                    color = Color(0xFF242424)
                )
            }
            Text(
                text = article.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )
            Text(
                text = article.excerpt,
                fontSize = 14.sp,
                color = Color(0xFF6B6B6B)
            )
            // Row de la metadata: tiempo de lectura y fecha.
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "${article.readingMinutes} min de lectura",
                    fontSize = 12.sp,
                    color = Color(0xFF6B6B6B)
                )
                Text(
                    text = "·",
                    fontSize = 12.sp,
                    color = Color(0xFF6B6B6B)
                )
                Text(
                    text = article.date,
                    fontSize = 12.sp,
                    color = Color(0xFF6B6B6B)
                )
            }
        }
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(colorMiniatura)
        )
    }
}