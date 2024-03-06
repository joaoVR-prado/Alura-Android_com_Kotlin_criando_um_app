package com.example.orgs.ui.dao

import com.example.orgs.ui.model.Produto

class ProdutosDao {
    fun adicionarProduto(produto: Produto){
        produtos.add(produto)

    }

    fun listaProdutos() : List<Produto>{
        return Companion.produtos.toList()

    }

    companion object {
        private val produtos = mutableListOf<Produto>()

    }

}