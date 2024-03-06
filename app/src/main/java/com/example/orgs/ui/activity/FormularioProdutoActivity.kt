package com.example.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.R
import com.example.orgs.ui.dao.ProdutosDao
import com.example.orgs.ui.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)

        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = produto()
            dao.adicionarProduto(produtoNovo)
            finish()

        }
    }

    private fun produto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val nome = campoNome.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = campoDescricao.text.toString()

        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor)
        val valorEmTexto = campoValor.text.toString()

        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO

        } else {
            BigDecimal(valorEmTexto)

        }

        return Produto(
            titulo = nome,
            descricao = descricao,
            valor = valor

        )
    }
}

//.ui.activity.FormularioProdutoActivity
//.ui.activity.MainActivity