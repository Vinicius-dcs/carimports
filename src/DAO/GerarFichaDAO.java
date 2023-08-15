/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import Interfaces.GerarFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author vinic
 */
public class GerarFichaDAO {

    private Connection con = null;

    public GerarFichaDAO() throws ClassNotFoundException { //Conexão, ao instanciar esta classe ja abre conexão
        con = ConnectionFactory.getConnection();
    }

    public GerarFichaDAO(GerarFicha aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet select(String codigo) throws SQLException, JRException {
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, codigo);
            rs = stmt.executeQuery(); //Envia SQL preenchido para banco
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return rs;
    }

}
