/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import Modelo.Excluir;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class ExcluirFichaDAO {

    private Connection con = null;

    public ExcluirFichaDAO() throws ClassNotFoundException { //Conexão, ao instanciar esta classe ja abre conexão
        con = ConnectionFactory.getConnection();
    }

    public boolean existeCodigoNoBanco(Excluir codigo) throws SQLException {
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);//Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, codigo.getCodigo());//Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return rs.next();//retorna true ou false se existe uma linha ou proxima linha do resultado da variavel rs
    }

    public boolean delete(Excluir codigo) throws SQLException {
        String sql = "DELETE FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;

        try {
        stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
        stmt.setString(1, codigo.getCodigo()); //Preenche valor ?
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
