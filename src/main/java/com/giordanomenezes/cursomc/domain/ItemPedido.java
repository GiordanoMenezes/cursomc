/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Giordano
 */
@Entity
public class ItemPedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    
    private BigDecimal desconto;
    private Integer quantidade;
    private BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto,Pedido pedido,BigDecimal desconto, Integer quantidade, BigDecimal preco) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }
    
    public Produto getProduto() {
        return id.getProduto();
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
