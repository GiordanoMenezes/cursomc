/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.domain;

import com.giordanomenezes.cursomc.domain.enums.EstadoPagamento;
import javax.persistence.Entity;

/**
 *
 * @author Giordano
 */
@Entity
public class PagamentoComCartao extends Pagamento {
    
    private static final long serialVersionUID = 1L;
    
    private Integer numParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer numParcelas, EstadoPagamento estado, Pedido pedido) {
        super(estado, pedido);
        this.numParcelas = numParcelas;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }
    
    

}
