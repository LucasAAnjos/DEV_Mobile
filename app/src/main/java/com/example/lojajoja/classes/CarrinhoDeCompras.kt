package com.example.lojajoja.classes

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class CarrinhoDeCompras{
    public var lista : MutableList<Produto> = mutableListOf()

    fun adicionarProduto(produto: Produto, quantidade : Int){
        produto.estoque = quantidade
        lista.add(produto)
    }

    fun removerProduto(produto: Produto, quantidade : Int){
        lista.remove(produto)
    }

    fun calcularTotal() : Double{
       var total : Double = 0.0
        for (product in lista){
           total += product.preco
        }
        return total
    }
}

