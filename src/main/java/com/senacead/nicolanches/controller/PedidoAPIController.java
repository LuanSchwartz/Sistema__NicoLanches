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

import com.senacead.nicolanches.model.Pedido;
import com.senacead.nicolanches.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedido")  
public class PedidoAPIController {

    @Autowired
    private PedidoService pedidoService;
    
   
    @PostMapping("/adicionar")
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criar(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED); 
    }
    
    
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> listarTodosPedidos = pedidoService.buscarTodos();
        return new ResponseEntity<>(listarTodosPedidos, HttpStatus.OK);  
    }
    
   
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
        Pedido pedidoEncontrado = pedidoService.buscarPorId(id);
        return new ResponseEntity<>(pedidoEncontrado, HttpStatus.OK); 
    }
    
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido pedidoAtualizado = pedidoService.atualizar(id, pedido);
        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK); 
    }
    
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        pedidoService.excluir(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }
}
