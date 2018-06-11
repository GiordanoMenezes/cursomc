/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.resources;

import com.giordanomenezes.cursomc.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giordano
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaReource {
    
    @GetMapping
    public List<Categoria> listar() {
        
        Categoria cat1 = new Categoria(1,"Informática");
        Categoria cat2 = new Categoria(2,"Escritório");
        
        List<Categoria> listacat = new ArrayList<>();
        
        listacat.add(cat1);
        listacat.add(cat2);
        
        return listacat;
    }
}
