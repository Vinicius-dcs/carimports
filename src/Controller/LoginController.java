/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import Interfaces.Login;
import Interfaces.Menu;
import Modelo.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class LoginController {
    private Login login;

    public LoginController(Login login) {
        this.login = login;
    }
    
    public void autenticar() throws ClassNotFoundException, SQLException {
        
        //Buscar usuario no login
        String usuario = login.getPreencherUsuario().getText();
        String senha = login.getPreencherSenha().getText();
        Usuario user = new Usuario(usuario, senha);
        
        //Verificar se existe no banco de dados
        LoginDAO loginDAO = new LoginDAO();
        if(loginDAO.existeLogin(user) == true) {
            login.dispose();
            new Menu().setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
        }
        
    }
}
