/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Cliente;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class ClienteDaoImpl implements Serializable{
    
    private Connection conexao;
    private PreparedStatement preparando;
    private ResultSet resulset;
    
    public void salvar(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO cliente(nome, email, telefone, salario) VALUES()(?,?,?,?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, cliente.getNome());
            preparando.setString(2, cliente.getEmail());
            preparando.setString(3, cliente.getTelefone());
            preparando.setDouble(4, cliente.getSalario());
            preparando.executeUpdate();
        } catch (SQLException eSQL){
            System.out.println("Erro ao salvar cliente!!!" + eSQL.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }
}

