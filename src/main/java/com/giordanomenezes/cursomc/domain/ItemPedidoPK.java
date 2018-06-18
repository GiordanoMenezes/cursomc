/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Giordano
 */
@Embeddable
public class ItemPedidoPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.pedido);
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
        final ItemPedidoPK other = (ItemPedidoPK) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }
    
    
    
}
