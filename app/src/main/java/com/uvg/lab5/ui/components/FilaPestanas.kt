package com.uvg.lab5.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilaPestanas(
    pestanas: List<String>,
    pestanaActiva: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        pestanas.forEach { pestana ->
            val activa = pestana == pestanaActiva
            Text(
                text = pestana,
                fontSize = 14.sp,
                fontWeight = if (activa) FontWeight.Bold else FontWeight.Normal,
                color = if (activa) Color(0xFF242424) else Color(0xFF6B6B6B)
            )
        }
    }
}