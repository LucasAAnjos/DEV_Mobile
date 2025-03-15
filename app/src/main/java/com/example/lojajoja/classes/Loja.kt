package com.example.lojajoja.classes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Loja {
    public var lista : MutableList<Produto> = mutableListOf()

    fun adicionarProduto(produto: Produto){
        lista.add(produto)
    }

    fun removerProduto(produto: Produto, quantidade : Int){
        lista.remove(produto)
    }

    @Composable
    fun finalizarCompra(cliente: Cliente, carrinhoDeCompras: CarrinhoDeCompras){
        if (carrinhoDeCompras.calcularTotal() <= cliente.saldo){
            var listaBackup = lista
            for (produto in carrinhoDeCompras.lista){
                if (!lista.contains(produto)) {
                    Text(
                        text = "Saldo insuficiente"
                    )
                    return
                }
                lista.get(lista.indexOf(produto)).estoque -= produto.estoque
            }
            cliente.saldo -= carrinhoDeCompras.calcularTotal()
            Text(
                text = "Novo saldo: R$${cliente.saldo}"
            )
        } else {
            Text(
                text = "Saldo insuficiente"
            )
        }
    }

    @Composable
    fun listarProdutos(){
        for (produto in lista){
            Text(
                text = produto.nome
            )
        }
    }
}