/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CopiarFichaDAO;
import Interfaces.CopiarFicha;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CopiarFichaController {

    private final CopiarFicha telaCopiarFicha;
    private Connection con;

    public CopiarFichaController(CopiarFicha telaCopiarFicha) {
        this.telaCopiarFicha = telaCopiarFicha;
    }

    public boolean camposVazios() {
        boolean vazioCampoCodigoCopiado = false;
        boolean vazioCampoCodigoReceber = false;
        
        if(telaCopiarFicha.getjTextField_CodigoReceberCopia().getText().isEmpty()) {
            vazioCampoCodigoReceber = true;
        }
        if(telaCopiarFicha.getjTextField_CodigoSerCopiado().getText().isEmpty()){
            vazioCampoCodigoCopiado = true;
        }

        if(vazioCampoCodigoReceber == false && vazioCampoCodigoCopiado == false) {
            return false;
        } else {
            return true;
        }
    }

    public void copiarFicha() throws ClassNotFoundException, SQLException {
        String codigoSerCopiado = telaCopiarFicha.getjTextField_CodigoSerCopiado().getText();
        String codigoReceberCopia = telaCopiarFicha.getjTextField_CodigoReceberCopia().getText();
        CopiarFichaDAO copiarFichaDAO = new CopiarFichaDAO();

        if (camposVazios() == false) {
            if (copiarFichaDAO.existeCodigoCopiadoNoBanco(codigoSerCopiado) == true) {
                if(copiarFichaDAO.existeCodigoReceberCopiaNoBanco(codigoReceberCopia) == false) {
                    copiarFichaDAO.selectInsert(codigoSerCopiado, codigoReceberCopia);
                } else {
                    JOptionPane.showMessageDialog(null, "O código do produto a receber a cópia já existe cadastrado!");
                } 
            } else {
                JOptionPane.showMessageDialog(null, "O código do produto copiado não existe cadastrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }

}
