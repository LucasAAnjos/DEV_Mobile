package com.example.lojajoja.classes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class Cliente (
    val id: Int,
    val nome: String,
    var saldo : Double = 0.0,
    var carrinho : CarrinhoDeCompras = CarrinhoDeCompras()
){
    fun adicionarSaldo(saldoAdd: Double){
        saldo += saldoAdd;
    }

    @Composable
    fun exibirSaldo(){
        Text(
            text = "$saldo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TesteCliente() {
    val cliente1 = Cliente(1, "Jooooj", 500.0);
    cliente1.exibirSaldo();
}