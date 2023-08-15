/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class ConnectionFactory {
    
    private static final String DRIVE = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://192.168.0.107/fichaTecnica";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    
    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
                //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement smtm) {
        if(smtm != null) {
            try {
                smtm.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
                //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement smtm, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro:" + ex);
                //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeConnection(con, smtm);
    }   
}
