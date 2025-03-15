package com.example.lojajoja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lojajoja.classes.CarrinhoDeCompras
import com.example.lojajoja.classes.Cliente
import com.example.lojajoja.classes.Loja
import com.example.lojajoja.classes.Produto
import com.example.lojajoja.ui.theme.LojaJojaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojaJojaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "cu de pica",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val produto1 = Produto(2, "Pao", 10.0, 10)
    val produto2 = Produto(15, "Água", 0.99, 20)

    //Classe Carrinho foi incorporada e inicializada ao cliente
    val cliente1 = Cliente(1, "Jorge", 200.0)

    val loja1 = Loja()

    loja1.adicionarProduto(produto1)
    loja1.adicionarProduto(produto2)

    cliente1.carrinho.adicionarProduto(produto1, 10)
    cliente1.carrinho.adicionarProduto(produto2, 15)

    var total = cliente1.carrinho.calcularTotal()
    
    LojaJojaTheme {
        Column {
            Row{
                Column {
                    Row {
                        Text("Cliente: ${cliente1.nome}")
                    }
                    Row{
                        Text("Saldo: R$${cliente1.saldo}")
                    }
                    Row {
                        Text("Compra: R$${cliente1.carrinho.calcularTotal()}")
                    }
                    Row {
                        Text("${loja1.lista.get(1).estoque}")
                    }
                    Row {
                        loja1.finalizarCompra(cliente1, cliente1.carrinho)
                    }
                    Row {
                        Text("${loja1.lista.get(1).estoque}")
                    }
                }

            }

        }

    }
}