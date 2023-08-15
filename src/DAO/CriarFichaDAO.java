/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import Modelo.Ficha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CriarFichaDAO {

    private Connection con = null;

    public CriarFichaDAO() throws ClassNotFoundException  { //Conexão, ao instanciar esta classe ja abre conexão
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Ficha ficha) {
        String sql = "INSERT INTO ficha (nomecolchao, codigo, suportepeso, pilloweuro, revestsuperior, revestlateral, revestinferior, molejo, nivelconforto, garantiacolchao, garantiabase, estruturabase, revestsupbase, revestlatbase, pes, altcolchao, altbase, altpes, alttotalconjunto, comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9, comp10, comp11, comp12, comp13, comp14, diferencial1, diferencial2, diferencial3, diferencial4, diferencial5, imagem) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, ficha.getNomeColchao()); //Preenche o primeiro ?
            stmt.setString(2, ficha.getCodigo()); //Preenche o segundo ?
            stmt.setString(3, ficha.getSuportePeso());
            stmt.setString(4, ficha.getPillowEuro());
            stmt.setString(5, ficha.getRevestSuperior());
            stmt.setString(6, ficha.getRevestLateral());
            stmt.setString(7, ficha.getRevestInferior());
            stmt.setString(8, ficha.getMolejo());
            stmt.setString(9, ficha.getNivelConforto());
            stmt.setString(10, ficha.getGarantiaColchao());
            stmt.setString(11, ficha.getGarantiaBase());
            stmt.setString(12, ficha.getEstruturaBase());
            stmt.setString(13, ficha.getRevestSupBase());
            stmt.setString(14, ficha.getRevestLatBase());
            stmt.setString(15, ficha.getPes());
            stmt.setString(16, ficha.getAltColchao());
            stmt.setString(17, ficha.getAltBase());
            stmt.setString(18, ficha.getAltPes());
            stmt.setString(19, ficha.getAltTotalConjunto());
            stmt.setString(20, ficha.getComp1());
            stmt.setString(21, ficha.getComp2());
            stmt.setString(22, ficha.getComp3());
            stmt.setString(23, ficha.getComp4());
            stmt.setString(24, ficha.getComp5());
            stmt.setString(25, ficha.getComp6());
            stmt.setString(26, ficha.getComp7());
            stmt.setString(27, ficha.getComp8());
            stmt.setString(28, ficha.getComp9());
            stmt.setString(29, ficha.getComp10());
            stmt.setString(30, ficha.getComp11());
            stmt.setString(31, ficha.getComp12());
            stmt.setString(32, ficha.getComp13());
            stmt.setString(33, ficha.getComp14());
            stmt.setString(34, ficha.getDiferencial1());
            stmt.setString(35, ficha.getDiferencial2());
            stmt.setString(36, ficha.getDiferencial3());
            stmt.setString(37, ficha.getDiferencial4());
            stmt.setString(38, ficha.getDiferencial5());
            stmt.setBytes(39, ficha.getImagem());
            //stmt.setBytes(40, ficha.getImagem());
            stmt.execute(); //Envia SQL preenchido para banco
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            //Logger.getLogger(CriarFichaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean existeFichaNoBanco(Ficha ficha) throws SQLException {
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, ficha.getCodigo()); //Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return rs.next();//retorna true ou false se existe uma linha ou proxima linha do resultado da variavel rs
    }

}
