/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.visao;

import br.com.associacao.entidade.Cliente;
import br.com.associacao.entidade.Endereco;
import br.com.associacao.controle.ClienteControle;
import br.com.utilitario.UtilGerador;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class TestaCliente {
    
    private static ClienteControle controle = new ClienteControle();
    
    public static void main(String[] args) {
        String menu;
        do {
            menu = JOptionPane.showInputDialog("Escolha opção:"
                    + "\n(1)-Salvar"
                    + "\n(2)-Pesquisar por nome"
                    + "\n(3)-"
                    + "\n(4)-"
                    + "\n(5)-Sair"
            );
            
            switch(menu){
                case "1":
                    Cliente cliente = criarCliente();
                    controle.salvar(cliente);
                    System.out.println("Cliente cadastrado");
                    mostrar(cliente);
                    System.out.println("=========================");
                    break;
                 case "2":
                    String nome = JOptionPane.showInputDialog("Informe o nome a ser pesquisado: ");
                    List<Cliente> clientes = controle.pesquisarPorNome(nome);
                    if (clientes.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não localizado!!!");
                    } else {
                        System.out.println("----====Pesquisa por nome====---- ");
                        for (Cliente cliente1 : clientes) {
                            mostrar(cliente1);
                            System.out.println("=========================");
                        }
                    }
                    break;    
                    
                case "5":
                    
                    break;
            }
            
        } while (!menu.equals("5"));
    }
    
    private static Cliente criarCliente(){
        Integer id = controle.pegarUltimoId();
        Cliente cliente = new Cliente(
                ++id,
                UtilGerador.gerarNome(),
                UtilGerador.gerarEmail("gmail"),
                Double.parseDouble(UtilGerador.gerarNumInteiro("4")),
                UtilGerador.gerarTelefone()
        );
        Endereco endereco = new Endereco(
                id++,
                UtilGerador.gerarLogradouro(),
                UtilGerador.gerarNumInteiro("4"),
                UtilGerador.gerarCidade(),
                UtilGerador.gerarBairro(),
                UtilGerador.gerarEstado()
        );
        cliente.setEndereco(endereco);
        return cliente;
    }
    
    private static void mostrar(Cliente cliente){
        System.out.println("Id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("Salário: " + cliente.getSalario());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Id Endereço: " + cliente.getEndereco().getId());
        System.out.println("Logradouro: " + cliente.getEndereco().getLogradouro());
        System.out.println("Numero: " + cliente.getEndereco().getNumero());
        System.out.println("Cidade: " + cliente.getEndereco().getCidade());
        System.out.println("Estado: " + cliente.getEndereco().getEstado());
        System.out.println("Bairro: " + cliente.getEndereco().getBairro());
      
    }

  
}
