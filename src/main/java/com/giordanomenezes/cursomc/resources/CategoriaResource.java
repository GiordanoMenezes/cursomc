/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.resources;

import com.giordanomenezes.cursomc.domain.Categoria;
import com.giordanomenezes.cursomc.services.CategoriaService;
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
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarporId(@PathVariable Long id) {
        Categoria catfind =  service.buscarporId(id);
        return ResponseEntity.ok().body(catfind);
    }
}
