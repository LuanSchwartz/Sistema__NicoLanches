package com.senacead.nicolanches.service;

import com.senacead.nicolanches.model.Cliente;
import com.senacead.nicolanches.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente) {
        cliente.setId(null); // Garante que é uma criação, não uma atualização
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void excluir(Integer id) {
        Cliente clienteEncontrado = buscarPorId(id); // Verifica se o cliente existe
        clienteRepository.deleteById(clienteEncontrado.getId());
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
    }

    public Cliente atualizar(Integer id, Cliente cliente) {
        Cliente clienteEncontrado = buscarPorId(id); 

       
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setCpf(cliente.getCpf()); 
        clienteEncontrado.setTelefone(cliente.getTelefone());

        clienteRepository.save(clienteEncontrado); 
        return clienteEncontrado;
    }
    
}
