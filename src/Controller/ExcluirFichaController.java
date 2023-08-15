/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ExcluirFichaDAO;
import Interfaces.ExcluirFicha;
import Modelo.Excluir;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class ExcluirFichaController {

    private final ExcluirFicha telaExcluirFicha;
    private Connection con;

    public ExcluirFichaController(ExcluirFicha telaExcluirFicha) {
        this.telaExcluirFicha = telaExcluirFicha;
    }

    public void excluirFicha() throws ClassNotFoundException, SQLException {
        String codigo = telaExcluirFicha.getjTextField_Codigo().getText();

        Excluir excluir = new Excluir(codigo);
        ExcluirFichaDAO excluirFichaDAO = new ExcluirFichaDAO();
        
        if(excluirFichaDAO.existeCodigoNoBanco(excluir) == true) {
            excluirFichaDAO.delete(excluir);
            JOptionPane.showMessageDialog(null, "Ficha deletada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O código não existe cadastrado!");
        }
    }
}
