/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giordanomenezes.cursomc.services;

import com.giordanomenezes.cursomc.domain.Cliente;
import com.giordanomenezes.cursomc.repositories.ClienteRepository;
import com.giordanomenezes.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscarporId(Long id) {
       Optional<Cliente> catfind = repo.findById(id);
       return catfind.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Cliente.class.getName()));
    }
}
