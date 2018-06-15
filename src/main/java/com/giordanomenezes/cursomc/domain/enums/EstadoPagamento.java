/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.domain.enums;

/**
 *
 * @author Giordano
 */
public enum EstadoPagamento {

    PEND("Pendente"), QUIT("Quitado"), CANC("Cancelado");

    private final String descricao;

    EstadoPagamento(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }
    
    

}
