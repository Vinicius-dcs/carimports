/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CadastroDAO {

    private Connection con = null;

    public CadastroDAO() throws ClassNotFoundException { //Conexão, ao instanciar esta classe ja abre conexão
        con = ConnectionFactory.getConnection();
    }

    public boolean existeUsuarioNoBanco(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM login WHERE usuario = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);//Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, usuario.getUsuario());//Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        } finally {
            //ConnectionFactory.closeConnection(con,stmt, rs);
        }
    }

    public boolean insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO login (usuario, nome, senha) VALUES (?,?,?)"; //Instrução SQL  
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, usuario.getUsuario()); //Preenche valor ?
            stmt.setString(2, usuario.getNome()); //Preenche valor ?
            stmt.setString(3, usuario.getSenha()); //Preenche valor ?
            stmt.execute(); //Envia SQL preenchido para banco
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
