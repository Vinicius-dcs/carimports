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
public class LoginDAO {

    private Connection con = null;

    public LoginDAO() throws ClassNotFoundException {
        con = ConnectionFactory.getConnection();
    }

    public boolean existeLogin(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);//Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, usuario.getUsuario());//Preenche ?
            stmt.setString(2, usuario.getSenha());//Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return rs.next();
    }

}
