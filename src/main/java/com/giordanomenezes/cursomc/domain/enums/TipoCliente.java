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
public enum TipoCliente {

    PF("Pessoa Física"), PJ("Pessoa Jurídica");

    private final String descricao;

    TipoCliente(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }
    
    

}
