/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CriarFichaDAO;
import Interfaces.CriarFicha;
import Interfaces.Login;
import Modelo.Ficha;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author vinic
 */

public class CriarFichaController {
    
    private final CriarFicha telaFicha;
    private Connection con;

    public CriarFichaController(CriarFicha telaFicha) {
        this.telaFicha = telaFicha;
    }

    private boolean selecionouImagem() {
        return telaFicha.getjTextField_Caminho().getText().isEmpty();
    }

    private byte[] converterImagem(File file) {
        try {
            return Files.readAllBytes(file.toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /*private byte[] converterImagem(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();

        return bytes;
    }*/
    
    public void salvarFicha() throws ClassNotFoundException, SQLException, IOException {
        String nomeColchao = telaFicha.getjTextField_NomeColchao().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        String codigo = telaFicha.getjTextField_Codigo().getText(); //Pega informação do campo que esta na tela e coloca na variavel
        String suportePeso = telaFicha.getjTextField_SuportePeso().getText();
        String pillowEuro = telaFicha.getjTextField_PillowEuro().getText();
        String revestSuperior = telaFicha.getjTextField_RevestSuperior().getText();
        String revestLateral = telaFicha.getjTextField_RevestLateral().getText();
        String revestInferior = telaFicha.getjTextField_RevestInferior().getText();
        String molejo = telaFicha.getjTextField_Molejo().getText();
        String nivelConforto = telaFicha.getjTextField_NivelConforto().getText();
        String garantiaColchao = telaFicha.getjTextField_GarantiaColchao().getText();
        String garantiaBase = telaFicha.getjTextField_GarantiaBase().getText();
        String estruturaBase = telaFicha.getjTextField_EstruturaBase().getText();
        String revestSupBase = telaFicha.getjTextField_RevestSupBase().getText();
        String revestLatBase = telaFicha.getjTextField_RevestLatBase().getText();
        String pes = telaFicha.getjTextField_Pes().getText();
        String altColchao = telaFicha.getjTextField_AltColchao().getText();
        String altBase = telaFicha.getjTextField_AltBase().getText();
        String altPes = telaFicha.getjTextField_AltPes().getText();
        String altTotalConjunto = telaFicha.getjTextField_AltTotalConjunto().getText();
        String comp1 = telaFicha.getjTextField_Comp1().getText();
        String comp2 = telaFicha.getjTextField_Comp2().getText();
        String comp3 = telaFicha.getjTextField_Comp3().getText();
        String comp4 = telaFicha.getjTextField_Comp4().getText();
        String comp5 = telaFicha.getjTextField_Comp5().getText();
        String comp6 = telaFicha.getjTextField_Comp6().getText();
        String comp7 = telaFicha.getjTextField_Comp7().getText();
        String comp8 = telaFicha.getjTextField_Comp8().getText();
        String comp9 = telaFicha.getjTextField_Comp9().getText();
        String comp10 = telaFicha.getjTextField_Comp10().getText();
        String comp11 = telaFicha.getjTextField_Comp11().getText();
        String comp12 = telaFicha.getjTextField_Comp12().getText();
        String comp13 = telaFicha.getjTextField_Comp13().getText();
        String comp14 = telaFicha.getjTextField_Comp14().getText();
        String diferencial1 = telaFicha.getjTextField_Diferencial1().getText();
        String diferencial2 = telaFicha.getjTextField_Diferencial2().getText();
        String diferencial3 = telaFicha.getjTextField_Diferencial3().getText();
        String diferencial4 = telaFicha.getjTextField_Diferencial4().getText();
        String diferencial5 = telaFicha.getjTextField_Diferencial5().getText();
        //String nomeElaborador = telaLogin.getPreencherUsuario().getText();

        if (selecionouImagem() == false) {
            byte[] byteImage = converterImagem(new File(telaFicha.getjTextField_Caminho().getText()));
            Ficha ficha = new Ficha(nomeColchao, codigo, suportePeso, pillowEuro, revestSuperior, revestLateral, revestInferior, molejo, nivelConforto, garantiaColchao, garantiaBase, estruturaBase, revestSupBase, revestLatBase, pes, altColchao, altBase, altPes, altTotalConjunto, comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9, comp10, comp11, comp12, comp13, comp14, diferencial1, diferencial2, diferencial3, diferencial4, diferencial5, byteImage);
            CriarFichaDAO criarFichaDAO = new CriarFichaDAO();

            if (criarFichaDAO.existeFichaNoBanco(ficha) == false) {
                criarFichaDAO.insert(ficha);
                JOptionPane.showMessageDialog(null, "Ficha cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Este produto ja está cadastrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma imagem!");
        }
    }

}
