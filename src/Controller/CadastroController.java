/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CadastroDAO;
import Interfaces.Cadastro;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CadastroController {

    private final Cadastro cadastro;
    private Connection con;

    public CadastroController(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public boolean existeCampoVazio(Usuario usuario) {
        boolean trava = false;
        if (cadastro.getPreencherUsuario().getText().isEmpty() || cadastro.getPreencherNome().getText().isEmpty() || cadastro.getPreencherSenha().getText().isEmpty() || cadastro.getConfirmarSenha().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
            return trava = true;
        } else {
            return trava = false;
        }
    }

    public boolean verificarSeSenhasSaoIguais() {
        String senha1 = cadastro.getPreencherSenha().getText();
        String senha2 = cadastro.getConfirmarSenha().getText();
        System.out.println(senha1);
        System.out.println(senha2);
        if (senha1.equals(senha2)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
            return false;
        }

    }

    public void salvarUsuario() throws SQLException, ClassNotFoundException {
        String user = cadastro.getPreencherUsuario().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        String email = cadastro.getPreencherNome().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        String senha = cadastro.getPreencherSenha().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        String confirmarSenha = cadastro.getConfirmarSenha().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        Usuario usuario = new Usuario(user, email, senha, confirmarSenha); //Cria objeto usuario

        CadastroDAO cadastroDAO = new CadastroDAO();
        if (existeCampoVazio(usuario) == false) {
            if (verificarSeSenhasSaoIguais() == true) {
                if (cadastroDAO.existeUsuarioNoBanco(usuario) == false) {
                    cadastroDAO.insert(usuario); //Executa SQL com todas as informações necessárias
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                    cadastro.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "O usuário não está disponível!");
                }
            }
        }
    }

}
