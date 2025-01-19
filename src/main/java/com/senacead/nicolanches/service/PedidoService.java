package com.senacead.nicolanches.service;

import com.senacead.nicolanches.model.Pedido;
import com.senacead.nicolanches.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository; // Corrigido o nome do repositório

    public Pedido criar(Pedido pedido) {
        pedido.setId(null); // Garante que é uma criação, não uma atualização
        return pedidoRepository.save(pedido); // Retorna o pedido salvo diretamente
    }

    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    public void excluir(Integer id) {
        Pedido pedidoEncontrado = buscarPorId(id); 
        pedidoRepository.deleteById(pedidoEncontrado.getId());
    }

    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));
    }

    public Pedido atualizar(Integer id, Pedido pedido) {
        Pedido pedidoEncontrado = buscarPorId(id); 

        
        pedidoEncontrado.setNome(pedido.getNome()); 
        pedidoEncontrado.setValor(pedido.getValor()); 

        return pedidoRepository.save(pedidoEncontrado); 
    }
}
