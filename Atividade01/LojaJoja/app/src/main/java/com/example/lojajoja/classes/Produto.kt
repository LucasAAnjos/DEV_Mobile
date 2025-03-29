package com.example.lojajoja.classes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lojajoja.Greeting
import com.example.lojajoja.ui.theme.LojaJojaTheme

class Produto (
    val id: Int,
    val nome:  String,
    var preco: Double,
    var estoque: Int
) {

    @Composable
    fun exibirDetalhes(){
        Text(
            text = "$id\t$nome\t$preco\t$estoque"
        )
    }
}
