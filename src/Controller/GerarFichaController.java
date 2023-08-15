/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GerarFichaDAO;
import Interfaces.GerarFicha;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vinic
 */
public class GerarFichaController {

    private final GerarFicha gerarFicha;
    private Connection con;

    public GerarFichaController(GerarFicha gerarFicha) {
        this.gerarFicha = gerarFicha;
    }

    public void executar() throws ClassNotFoundException, SQLException, JRException {
        String codigo = gerarFicha.getjTextField_CodigoGerarFicha().getText();
        GerarFichaDAO dao = new GerarFichaDAO();
        JRResultSetDataSource relatResul = new JRResultSetDataSource(dao.select(codigo));
        JasperPrint jpPrint = JasperFillManager.fillReport("Ficha.jasper", new HashMap(), relatResul);
        JasperViewer view = new JasperViewer(jpPrint, false);
        view.setVisible(true);
    }

}
