/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.resources;

import com.giordanomenezes.cursomc.domain.Cliente;
import com.giordanomenezes.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giordano
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarporId(@PathVariable Long id) {
        Cliente catfind =  service.buscarporId(id);
        return ResponseEntity.ok().body(catfind);
    }
}
