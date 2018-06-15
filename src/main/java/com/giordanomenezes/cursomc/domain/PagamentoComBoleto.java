/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.domain;

import com.giordanomenezes.cursomc.domain.enums.EstadoPagamento;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;

/**
 *
 * @author Giordano
 */
@Entity
public class PagamentoComBoleto extends Pagamento {
    
    private static final long serialVersionUID = 1L;
    
    private LocalDate dataVencimento;
    
    private LocalDateTime dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(LocalDate dataVencimento, LocalDateTime dataPagamento, EstadoPagamento estado, Pedido pedido) {
        super(estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
}
