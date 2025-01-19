package com.senacead.nicolanches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senacead.nicolanches.model.Cliente;
import com.senacead.nicolanches.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente") 
public class ClienteAPIController {

    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);  
    }
    
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> listarTodosClientes = clienteService.buscarTodos();
        return new ResponseEntity<>(listarTodosClientes, HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
        Cliente clienteEncontrado = clienteService.buscarPorId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        clienteService.excluir(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
