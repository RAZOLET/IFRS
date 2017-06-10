/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco.controller;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteController 
{ 
    public boolean inserir(int codigo, String nome)
    {
        String sql = "INSERT INTO cliente(nome, codigo) VALUES(?,?)";//define instrução SQL
        PreparedStatement ps;
        try
        {
        ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
        ps.setString(1, nome);//primeiro parâmetro indica a interrogação correspondente, segundo parâmetro a variável que substituirá a ?
        ps.setInt(2, codigo);//primeiro parâmetro indica a interrogação correspondente, segundo parâmetro a variável que substituirá a ?
        ps.execute();//executa SQL preparada
        return true;
        } catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void main(String[] args) 
    {
        ClienteController CC = new ClienteController();
        CC.inserir(10,"Zolet");
        CC.inserir(2, "Serigne");
        CC.inserir(3, "Lisiane");
        CC.inserir(11, "Fabio");
        
    }
}


