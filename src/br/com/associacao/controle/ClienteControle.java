/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.controle;

import br.com.associacao.entidade.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class ClienteControle implements Serializable{
    
    private List<Cliente> clientes = new ArrayList<>();
    
    public void salvar(Cliente cliente){
        clientes.add(cliente);
    }
    
    public Integer pegarUltimoId(){
        int tamanhoLista = clientes.size();
        if (tamanhoLista == 0){
            return 0;
        }
        Integer id = clientes.get(tamanhoLista - 1).getId();
        return id;
    }
    
    public List<Cliente> pesquisarPorNome(String nome){
        List<Cliente> clientesPesquisados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if(cliente.getNome().contains(nome)){
                clientesPesquisados.add(cliente);
            }
        }
        return clientesPesquisados;
    }
   
}
