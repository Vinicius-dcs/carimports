/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CopiarFichaDAO {

    private Connection con = null;

    public CopiarFichaDAO() throws ClassNotFoundException { //Conexão, ao instanciar esta classe ja abre conexão
        con = ConnectionFactory.getConnection();
    }

    public boolean existeCodigoCopiadoNoBanco(String codigoCopiado) throws SQLException {
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);//Abre uma preparação da instrução SQL para enviar ao banco
            stmt.setString(1, codigoCopiado);//Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        }

    }

    public boolean existeCodigoReceberCopiaNoBanco(String codigoReceber) throws SQLException {
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);//Abre uma preparação da instrução SQL para enviar ao banco
            stmt.setString(1, codigoReceber);
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        }
    }

    public boolean selectInsert(String codigoCopiado, String codigoReceber) {
        String sqlSelect = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlSelect); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, codigoCopiado); //Preenche valor ?
            rs = stmt.executeQuery(); //Envia SQL preenchido para banco

            while (rs.next()) {

                String nomeColchao = rs.getString("nomecolchao");
                String codigo = codigoReceber;
                String suportePeso = rs.getString("suportepeso");
                String pillowEuro = rs.getString("pilloweuro");
                String revestSuperior = rs.getString("revestsuperior");
                String revestLateral = rs.getString("revestlateral");
                String revestInferior = rs.getString("revestinferior");
                String molejo = rs.getString("molejo");
                String nivelConforto = rs.getString("nivelconforto");
                String garantiaColchao = rs.getString("garantiacolchao");
                String garantiaBase = rs.getString("garantiabase");
                String estruturaBase = rs.getString("estruturabase");
                String revestSupBase = rs.getString("revestsupbase");
                String revestLatBase = rs.getString("revestlatbase");
                String pes = rs.getString("pes");
                String altColchao = rs.getString("altcolchao");
                String altBase = rs.getString("altbase");
                String altPes = rs.getString("altpes");
                String altTotalConjunto = rs.getString("alttotalconjunto");
                String comp1 = rs.getString("comp1");
                String comp2 = rs.getString("comp2");
                String comp3 = rs.getString("comp3");
                String comp4 = rs.getString("comp4");
                String comp5 = rs.getString("comp5");
                String comp6 = rs.getString("comp6");
                String comp7 = rs.getString("comp7");
                String comp8 = rs.getString("comp8");
                String comp9 = rs.getString("comp9");
                String comp10 = rs.getString("comp10");
                String comp11 = rs.getString("comp11");
                String comp12 = rs.getString("comp12");
                String comp13 = rs.getString("comp13");
                String comp14 = rs.getString("comp14");
                String diferencial1 = rs.getString("diferencial1");
                String diferencial2 = rs.getString("diferencial2");
                String diferencial3 = rs.getString("diferencial3");
                String diferencial4 = rs.getString("diferencial4");
                String diferencial5 = rs.getString("diferencial5");
                byte[] imagem = rs.getBytes("imagem");

                String sqlInsert = "INSERT INTO ficha (nomecolchao, codigo, suportepeso, pilloweuro, revestsuperior, revestlateral, revestinferior, molejo, nivelconforto, garantiacolchao, garantiabase, estruturabase, revestsupbase, revestlatbase, pes, altcolchao, altbase, altpes, alttotalconjunto, comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9, comp10, comp11, comp12, comp13, comp14, diferencial1, diferencial2, diferencial3, diferencial4, diferencial5, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                stmt = null;
                stmt = con.prepareStatement(sqlInsert); //Abre uma preparação instrução SQL para enviar ao banco
                stmt.setString(1, nomeColchao);
                stmt.setString(2, codigo);
                stmt.setString(3, suportePeso);
                stmt.setString(4, pillowEuro);
                stmt.setString(5, revestSuperior);
                stmt.setString(6, revestLateral);
                stmt.setString(7, revestInferior);
                stmt.setString(8, molejo);
                stmt.setString(9, nivelConforto);
                stmt.setString(10, garantiaColchao);
                stmt.setString(11, garantiaBase);
                stmt.setString(12, estruturaBase);
                stmt.setString(13, revestSupBase);
                stmt.setString(14, revestLatBase);
                stmt.setString(15, pes);
                stmt.setString(16, altColchao);
                stmt.setString(17, altBase);
                stmt.setString(18, altPes);
                stmt.setString(19, altTotalConjunto);
                stmt.setString(20, comp1);
                stmt.setString(21, comp2);
                stmt.setString(22, comp3);
                stmt.setString(23, comp4);
                stmt.setString(24, comp5);
                stmt.setString(25, comp6);
                stmt.setString(26, comp7);
                stmt.setString(27, comp8);
                stmt.setString(28, comp9);
                stmt.setString(29, comp10);
                stmt.setString(30, comp11);
                stmt.setString(31, comp12);
                stmt.setString(32, comp13);
                stmt.setString(33, comp14);
                stmt.setString(34, diferencial1);
                stmt.setString(35, diferencial2);
                stmt.setString(36, diferencial3);
                stmt.setString(37, diferencial4);
                stmt.setString(38, diferencial5);
                stmt.setBytes(39, imagem);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Ficha copiada com sucesso!");
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        } 
       
    }

}
