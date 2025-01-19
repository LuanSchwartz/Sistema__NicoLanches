package com.senacead.nicolanches.controller;

import com.senacead.nicolanches.model.Cliente;
import com.senacead.nicolanches.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class NicoController {

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Pedido> listaPedidos = new ArrayList<>();

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio2() {
        return "index";
    }

    @GetMapping("/CadastroCliente")
    public String cadastre(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "CadastroCliente";
    }

    @PostMapping("/gravar")
    public String processarFormularioCliente(@ModelAttribute Cliente cliente, Model model) {
        cliente.setId(listaClientes.size() + 1);
        listaClientes.add(cliente);
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String listarClientes(Model model) {
        model.addAttribute("lista", listaClientes);
        return "listagem";
    }
    
    @GetMapping("/excluir-cliente")
    public String excluirCliente(Model model,@RequestParam String id){
    
        Integer idCliente = Integer.parseInt(id);
        
        Cliente registroEncontrado = new Cliente();
        for(Cliente l: listaClientes) {
         if(l.getId() == idCliente){
          registroEncontrado = l;
          break;
         }
        }
        listaClientes.remove(registroEncontrado);
        return "redirect:/listagem";
        }
    
<<<<<<< HEAD
    

=======
>>>>>>> 3b9ef4c (sistema final)
    @GetMapping("/RegistroPedido")
    public String registro(Model model){
        model.addAttribute("pedido", new Pedido());
        return "RegistroPedido";
}
    
    @PostMapping("/gravarPedido")
    public String processarFormularioPedido(@ModelAttribute Pedido pedido, Model model) {
        pedido.setId(listaPedidos.size() + 1);
        listaPedidos.add(pedido);
        return "redirect:/listagemPedido";
    }
    
    @GetMapping("/listagemPedido")
    public String listarPedidos(Model model) {
        model.addAttribute("listapedido", listaPedidos);
        return "listagemPedido";
    }
    
    @GetMapping("/excluir-pedido")
    public String excluirPedido(Model model,@RequestParam String id){
    
        Integer idPedido = Integer.parseInt(id);
        
        Pedido registroEncontrado = new Pedido();
        for(Pedido l: listaPedidos) {
         if(l.getId() == idPedido){
          registroEncontrado = l;
          break;
         }
        }
        listaPedidos.remove(registroEncontrado);
        return "redirect:/listagemPedido";
        }
    
}
