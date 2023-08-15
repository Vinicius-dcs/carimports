/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Conexao.ConnectionFactory;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author vinic
 */
public class AtualizarFicha extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form Ficha
     */
    public AtualizarFicha() {
        initComponents();

        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null); //Oculta botão
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); //Oculta as bordas do internalFrame
    }

    private byte[] converterImagem(File file) throws FileNotFoundException, IOException {
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
    }

    public void selecionarImagem() {
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione uma imagem");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY); //Seta busca de somente uma imagem por vez

        int opcao = arquivo.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            File file = new File("Caminho");
            file = arquivo.getSelectedFile(); //Recebe o caminho da imagem
            String caminhoImagem = file.getAbsolutePath();
            jTextField_Caminho.setText(caminhoImagem); //Mostra o caminho da imagem na tela

            ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
            jLabel_Imagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabel_Imagem.getWidth(), jLabel_Imagem.getHeight(), jLabel_Imagem.getWidth())));
        }
    }

    public boolean existeCodigo(String codigo) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM ficha WHERE codigo = ?";
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação da instrução SQL para enviar ao banco
            stmt.setString(1, codigo); //Preenche ?
            rs = stmt.executeQuery(); //pega linha ou linhas que geraram resultado a partir do select
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        }
    }

    public boolean select(String codigoProc) throws ClassNotFoundException, IOException {
        Connection con = ConnectionFactory.getConnection();
        AtualizarFicha tela = new AtualizarFicha();
        String sqlSelect = "SELECT * FROM ficha WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sqlSelect); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, codigoProc); //Preenche valor ?
            rs = stmt.executeQuery(); //Envia SQL preenchido para banco

            while (rs.next()) {
                String nomeColchao = rs.getString("nomecolchao");
                String codigo = rs.getString("codigo");
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

                jTextField_NomeColchao.setText(nomeColchao);
                jTextField_Codigo.setText(codigo);
                jTextField_SuportePeso.setText(suportePeso);
                jTextField_PillowEuro.setText(pillowEuro);
                jTextField_RevestSuperior.setText(revestSuperior);
                jTextField_RevestLateral.setText(revestLateral);
                jTextField_RevestInferior.setText(revestInferior);
                jTextField_Molejo.setText(molejo);
                jTextField_NivelConforto.setText(nivelConforto);
                jTextField_GarantiaColchao.setText(garantiaColchao);
                jTextField_GarantiaBase.setText(garantiaBase);
                jTextField_EstruturaBase.setText(estruturaBase);
                jTextField_RevestSupBase.setText(revestSupBase);
                jTextField_RevestLatBase.setText(revestLatBase);
                jTextField_Pes.setText(pes);
                jTextField_AltColchao.setText(altColchao);
                jTextField_AltBase.setText(altBase);
                jTextField_AltPes.setText(altPes);
                jTextField_AltTotalConjunto.setText(altTotalConjunto);
                jTextField_Comp1.setText(comp1);
                jTextField_Comp2.setText(comp2);
                jTextField_Comp3.setText(comp3);
                jTextField_Comp4.setText(comp4);
                jTextField_Comp5.setText(comp5);
                jTextField_Comp6.setText(comp6);
                jTextField_Comp7.setText(comp7);
                jTextField_Comp8.setText(comp8);
                jTextField_Comp9.setText(comp9);
                jTextField_Comp10.setText(comp10);
                jTextField_Comp11.setText(comp11);
                jTextField_Comp12.setText(comp12);
                jTextField_Comp13.setText(comp13);
                jTextField_Comp14.setText(comp14);
                jTextField_Diferencial1.setText(diferencial1);
                jTextField_Diferencial2.setText(diferencial2);
                jTextField_Diferencial3.setText(diferencial3);
                jTextField_Diferencial4.setText(diferencial4);
                jTextField_Diferencial5.setText(diferencial5);

                //Mostrar imagem na tela
                ByteArrayInputStream bis = new ByteArrayInputStream(imagem);
                BufferedImage bImage2 = ImageIO.read(bis);
                ImageIcon i = new ImageIcon(new ImageIcon(bImage2).getImage().getScaledInstance(jLabel_Imagem.getWidth(), jLabel_Imagem.getHeight(), Image.SCALE_SMOOTH));
                jLabel_Imagem.setIcon(i);
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        }
    }

    public boolean update() throws ClassNotFoundException, IOException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE ficha SET nomecolchao = ?, codigo = ?, suportepeso = ?, pilloweuro = ?, revestsuperior = ?, revestlateral = ?, revestinferior = ?, molejo = ?, nivelconforto = ?, garantiacolchao = ?, garantiabase = ?, estruturabase = ?, revestsupbase = ?, revestlatbase = ?, pes = ?, altcolchao = ?, altbase = ?, altpes = ?, alttotalconjunto = ?, comp1 = ?, comp2 = ?, comp3 = ?, comp4 = ?, comp5 = ?, comp6 = ?, comp7 = ?, comp8 = ?, comp9 = ?, comp10 = ?, comp11 = ?, comp12 = ?, comp13 = ?, comp14 = ?, diferencial1 = ?, diferencial2 = ?, diferencial3 = ?, diferencial4 = ?, diferencial5 = ?, imagem = ? WHERE codigo = ?";
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
            stmt.setString(1, jTextField_NomeColchao.getText());
            stmt.setString(2, jTextField_Codigo.getText());
            stmt.setString(3, jTextField_SuportePeso.getText());
            stmt.setString(4, jTextField_PillowEuro.getText());
            stmt.setString(5, jTextField_RevestSuperior.getText());
            stmt.setString(6, jTextField_RevestLateral.getText());
            stmt.setString(7, jTextField_RevestInferior.getText());
            stmt.setString(8, jTextField_Molejo.getText());
            stmt.setString(9, jTextField_NivelConforto.getText());
            stmt.setString(10, jTextField_GarantiaColchao.getText());
            stmt.setString(11, jTextField_GarantiaBase.getText());
            stmt.setString(12, jTextField_EstruturaBase.getText());
            stmt.setString(13, jTextField_RevestSupBase.getText());
            stmt.setString(14, jTextField_RevestLatBase.getText());
            stmt.setString(15, jTextField_Pes.getText());
            stmt.setString(16, jTextField_AltColchao.getText());
            stmt.setString(17, jTextField_AltBase.getText());
            stmt.setString(18, jTextField_AltPes.getText());
            stmt.setString(19, jTextField_AltTotalConjunto.getText());
            stmt.setString(20, jTextField_Comp1.getText());
            stmt.setString(21, jTextField_Comp2.getText());
            stmt.setString(22, jTextField_Comp3.getText());
            stmt.setString(23, jTextField_Comp4.getText());
            stmt.setString(24, jTextField_Comp5.getText());
            stmt.setString(25, jTextField_Comp6.getText());
            stmt.setString(26, jTextField_Comp7.getText());
            stmt.setString(27, jTextField_Comp8.getText());
            stmt.setString(28, jTextField_Comp9.getText());
            stmt.setString(29, jTextField_Comp10.getText());
            stmt.setString(30, jTextField_Comp11.getText());
            stmt.setString(31, jTextField_Comp12.getText());
            stmt.setString(32, jTextField_Comp13.getText());
            stmt.setString(33, jTextField_Comp14.getText());
            stmt.setString(34, jTextField_Diferencial1.getText());
            stmt.setString(35, jTextField_Diferencial2.getText());
            stmt.setString(36, jTextField_Diferencial3.getText());
            stmt.setString(37, jTextField_Diferencial4.getText());
            stmt.setString(38, jTextField_Diferencial5.getText());

           //Verifica se imagem foi alterada
            if (jTextField_Caminho.getText().isEmpty()) {
                sql = "SELECT * FROM ficha WHERE codigo = ?";
                ResultSet rs = null;
                PreparedStatement stmt2 = null;
                stmt2 = con.prepareStatement(sql); //Abre uma preparação instrução SQL para enviar ao banco
                stmt2.setString(1, jTextField_CodigoProcurar.getText()); //Preenche valor ?
                rs = stmt2.executeQuery(); //Envia SQL preenchido para banco
                byte[] imagem = null;
                while (rs.next()) {
                    imagem = rs.getBytes("imagem");
                }
                stmt.setBytes(39, imagem);
            } else {
                stmt.setBytes(39, converterImagem(new File(getjTextField_Caminho().getText())));
            }
           
            stmt.setString(40, jTextField_CodigoProcurar.getText());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Ficha atualizada com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            return false;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4_fundoAzul = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        procurar_botao = new javax.swing.JPanel();
        procurar_txt = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_NomeColchao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_SuportePeso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_PillowEuro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_RevestSuperior = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_RevestLateral = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_RevestInferior = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Molejo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_NivelConforto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_GarantiaColchao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_GarantiaBase = new javax.swing.JTextField();
        jTextField_EstruturaBase = new javax.swing.JTextField();
        jTextField_RevestSupBase = new javax.swing.JTextField();
        jTextField_RevestLatBase = new javax.swing.JTextField();
        jTextField_Pes = new javax.swing.JTextField();
        jTextField_AltColchao = new javax.swing.JTextField();
        jTextField_AltBase = new javax.swing.JTextField();
        jTextField_AltPes = new javax.swing.JTextField();
        jTextField_AltTotalConjunto = new javax.swing.JTextField();
        jTextField_CodigoProcurar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField_Comp1 = new javax.swing.JTextField();
        jTextField_Comp2 = new javax.swing.JTextField();
        jTextField_Comp3 = new javax.swing.JTextField();
        jTextField_Comp4 = new javax.swing.JTextField();
        jTextField_Comp5 = new javax.swing.JTextField();
        jTextField_Comp6 = new javax.swing.JTextField();
        jTextField_Comp7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField_Diferencial1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        atualizar_botao = new javax.swing.JPanel();
        atualizar_txt = new javax.swing.JLabel();
        jLabel_Imagem = new javax.swing.JLabel();
        jButton_Adicionar = new javax.swing.JButton();
        jTextField_Caminho = new javax.swing.JTextField();
        jTextField_Comp8 = new javax.swing.JTextField();
        jTextField_Comp9 = new javax.swing.JTextField();
        jTextField_Comp10 = new javax.swing.JTextField();
        jTextField_Comp11 = new javax.swing.JTextField();
        jTextField_Comp12 = new javax.swing.JTextField();
        jTextField_Comp13 = new javax.swing.JTextField();
        jTextField_Comp14 = new javax.swing.JTextField();
        jTextField_Diferencial2 = new javax.swing.JTextField();
        jTextField_Diferencial3 = new javax.swing.JTextField();
        jTextField_Diferencial4 = new javax.swing.JTextField();
        jTextField_Diferencial5 = new javax.swing.JTextField();

        setBorder(null);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(640, 520));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4_fundoAzul.setBackground(new java.awt.Color(36, 46, 68));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Código");

        procurar_botao.setBackground(new java.awt.Color(89, 199, 198));

        procurar_txt.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        procurar_txt.setForeground(new java.awt.Color(255, 255, 255));
        procurar_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        procurar_txt.setText("Procurar");
        procurar_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        procurar_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                procurar_txtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                procurar_txtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                procurar_txtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout procurar_botaoLayout = new javax.swing.GroupLayout(procurar_botao);
        procurar_botao.setLayout(procurar_botaoLayout);
        procurar_botaoLayout.setHorizontalGroup(
            procurar_botaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(procurar_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        procurar_botaoLayout.setVerticalGroup(
            procurar_botaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(procurar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nome Colchão");

        jTextField_NomeColchao.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_NomeColchao.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código");

        jTextField_Codigo.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Codigo.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Suporte Peso");

        jTextField_SuportePeso.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_SuportePeso.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pillow/Euro");

        jTextField_PillowEuro.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_PillowEuro.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Revest. Superior");

        jTextField_RevestSuperior.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_RevestSuperior.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Revest. Lateral");

        jTextField_RevestLateral.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_RevestLateral.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Revest. Inferior");

        jTextField_RevestInferior.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_RevestInferior.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Molejo");

        jTextField_Molejo.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Molejo.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nível de Conforto");

        jTextField_NivelConforto.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_NivelConforto.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Garantia Colchão");

        jTextField_GarantiaColchao.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_GarantiaColchao.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Garantia Base");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estrutura Base");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Revest. Sup. Base");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Revest. Lat. Base");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pés");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Alt. Colch. (M)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Alt. Base (M)");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Alt. Pés (M)");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Alt. Total Conjunto");

        jTextField_GarantiaBase.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_GarantiaBase.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_EstruturaBase.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_EstruturaBase.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_RevestSupBase.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_RevestSupBase.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_RevestLatBase.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_RevestLatBase.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_Pes.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Pes.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_AltColchao.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_AltColchao.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_AltBase.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_AltBase.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_AltPes.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_AltPes.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_AltTotalConjunto.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_AltTotalConjunto.setPreferredSize(new java.awt.Dimension(15, 25));

        jTextField_CodigoProcurar.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_CodigoProcurar.setPreferredSize(new java.awt.Dimension(15, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Composição do Produto");

        jTextField_Comp1.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp1.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp2.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp2.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp3.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp3.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp4.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp4.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp5.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp5.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp6.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp6.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp7.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp7.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("1");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("2");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("3");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("4");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("5");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("6");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("7");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("8");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("9");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("10");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("11");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("12");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("13");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("14");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Diferencial do Produto");

        jTextField_Diferencial1.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Diferencial1.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Imagem");

        atualizar_botao.setBackground(new java.awt.Color(89, 199, 198));

        atualizar_txt.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        atualizar_txt.setForeground(new java.awt.Color(255, 255, 255));
        atualizar_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atualizar_txt.setText("Atualizar");
        atualizar_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atualizar_txtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atualizar_txtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atualizar_txtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout atualizar_botaoLayout = new javax.swing.GroupLayout(atualizar_botao);
        atualizar_botao.setLayout(atualizar_botaoLayout);
        atualizar_botaoLayout.setHorizontalGroup(
            atualizar_botaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atualizar_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        atualizar_botaoLayout.setVerticalGroup(
            atualizar_botaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atualizar_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jLabel_Imagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_Adicionar.setText("Adicionar");
        jButton_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AdicionarActionPerformed(evt);
            }
        });

        jTextField_Comp8.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp8.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp9.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp9.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp10.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp10.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp11.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp11.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp12.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp12.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp13.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp13.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Comp14.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Comp14.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Diferencial2.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Diferencial2.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Diferencial3.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Diferencial3.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Diferencial4.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Diferencial4.setPreferredSize(new java.awt.Dimension(25, 25));

        jTextField_Diferencial5.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField_Diferencial5.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout jPanel4_fundoAzulLayout = new javax.swing.GroupLayout(jPanel4_fundoAzul);
        jPanel4_fundoAzul.setLayout(jPanel4_fundoAzulLayout);
        jPanel4_fundoAzulLayout.setHorizontalGroup(
            jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_CodigoProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_NomeColchao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_NivelConforto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_GarantiaColchao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Molejo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_RevestInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_RevestLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_RevestSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(20, 20, 20)
                                        .addComponent(jTextField_RevestLatBase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(104, 104, 104)
                                        .addComponent(jTextField_Pes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(40, 40, 40)
                                        .addComponent(jTextField_AltColchao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(50, 50, 50)
                                        .addComponent(jTextField_AltBase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(57, 57, 57)
                                        .addComponent(jTextField_AltPes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_AltTotalConjunto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_PillowEuro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_SuportePeso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(46, 46, 46)
                                        .addComponent(jTextField_GarantiaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(39, 39, 39)
                                        .addComponent(jTextField_EstruturaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_RevestSupBase, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_Comp4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_Comp11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Comp8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Comp14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Imagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addComponent(jButton_Adicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addComponent(atualizar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_Diferencial5, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Diferencial4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Diferencial3, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Diferencial2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Diferencial1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4_fundoAzulLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(procurar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel4_fundoAzulLayout.setVerticalGroup(
            jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField_CodigoProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(procurar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_NomeColchao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_GarantiaBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_SuportePeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_EstruturaBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_PillowEuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_RevestSupBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_RevestSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_RevestLatBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_RevestLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_Pes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_RevestInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_AltColchao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Molejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_AltBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_GarantiaColchao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_AltPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_NivelConforto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_AltTotalConjunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)))
                            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField_Comp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24)))
                                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Comp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jTextField_Comp7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35)))
                            .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4_fundoAzulLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField_Comp9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel31)))
                                    .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Comp8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Comp10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jTextField_Comp14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Diferencial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Diferencial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Diferencial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Diferencial4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Diferencial5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4_fundoAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Adicionar)
                    .addComponent(jTextField_Caminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(atualizar_botao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jScrollPane2.setViewportView(jPanel4_fundoAzul);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procurar_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procurar_txtMouseClicked
        try {
            if (existeCodigo(jTextField_CodigoProcurar.getText()) == true) {
                select(jTextField_CodigoProcurar.getText());
            } else {
                JOptionPane.showMessageDialog(null, "O código procurado não existe cadastrado!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

    }//GEN-LAST:event_procurar_txtMouseClicked

    private void procurar_txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procurar_txtMouseEntered
        procurar_txt.setForeground(new java.awt.Color(36, 46, 68));
    }//GEN-LAST:event_procurar_txtMouseEntered

    private void procurar_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procurar_txtMouseExited
        procurar_txt.setForeground(Color.white);
    }//GEN-LAST:event_procurar_txtMouseExited

    private void atualizar_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizar_txtMouseClicked
        try {
            update();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        
    }//GEN-LAST:event_atualizar_txtMouseClicked

    private void atualizar_txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizar_txtMouseEntered
        atualizar_txt.setForeground(new java.awt.Color(36, 46, 68));
    }//GEN-LAST:event_atualizar_txtMouseEntered

    private void atualizar_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizar_txtMouseExited
        atualizar_txt.setForeground(Color.white);
    }//GEN-LAST:event_atualizar_txtMouseExited

    private void jButton_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AdicionarActionPerformed
        selecionarImagem();
    }//GEN-LAST:event_jButton_AdicionarActionPerformed

    public JPanel getCadastrar_botao1() {
        return atualizar_botao;
    }

    public void setCadastrar_botao1(JPanel cadastrar_botao1) {
        this.atualizar_botao = cadastrar_botao1;
    }

    public JLabel getCadastrar_txt1() {
        return atualizar_txt;
    }

    public void setCadastrar_txt1(JLabel cadastrar_txt1) {
        this.atualizar_txt = cadastrar_txt1;
    }

    public JButton getjButton_Adicionar() {
        return jButton_Adicionar;
    }

    public void setjButton_Adicionar(JButton jButton_Adicionar) {
        this.jButton_Adicionar = jButton_Adicionar;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel33() {
        return jLabel33;
    }

    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }

    public JLabel getjLabel34() {
        return jLabel34;
    }

    public void setjLabel34(JLabel jLabel34) {
        this.jLabel34 = jLabel34;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }

    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel38() {
        return jLabel38;
    }

    public void setjLabel38(JLabel jLabel38) {
        this.jLabel38 = jLabel38;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JLabel getjLabel_Imagem() {
        return jLabel_Imagem;
    }

    public void setjLabel_Imagem(JLabel jLabel_Imagem) {
        this.jLabel_Imagem = jLabel_Imagem;
    }

    public JPanel getjPanel4_fundoAzul() {
        return jPanel4_fundoAzul;
    }

    public void setjPanel4_fundoAzul(JPanel jPanel4_fundoAzul) {
        this.jPanel4_fundoAzul = jPanel4_fundoAzul;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTextField getjTextField_AltBase() {
        return jTextField_AltBase;
    }

    public void setjTextField_AltBase(JTextField jTextField_AltBase) {
        this.jTextField_AltBase = jTextField_AltBase;
    }

    public JTextField getjTextField_AltColchao() {
        return jTextField_AltColchao;
    }

    public void setjTextField_AltColchao(JTextField jTextField_AltColchao) {
        this.jTextField_AltColchao = jTextField_AltColchao;
    }

    public JTextField getjTextField_AltPes() {
        return jTextField_AltPes;
    }

    public void setjTextField_AltPes(JTextField jTextField_AltPes) {
        this.jTextField_AltPes = jTextField_AltPes;
    }

    public JTextField getjTextField_AltTotalConjunto() {
        return jTextField_AltTotalConjunto;
    }

    public void setjTextField_AltTotalConjunto(JTextField jTextField_AltTotalConjunto) {
        this.jTextField_AltTotalConjunto = jTextField_AltTotalConjunto;
    }

    public JTextField getjTextField_Caminho() {
        return jTextField_Caminho;
    }

    public void setjTextField_Caminho(JTextField jTextField_Caminho) {
        this.jTextField_Caminho = jTextField_Caminho;
    }

    public JTextField getjTextField_Codigo() {
        return jTextField_Codigo;
    }

    public void setjTextField_Codigo(JTextField jTextField_Codigo) {
        this.jTextField_Codigo = jTextField_Codigo;
    }

    public JTextField getjTextField_CodigoProcurar() {
        return jTextField_CodigoProcurar;
    }

    public void setjTextField_CodigoProcurar(JTextField jTextField_CodigoProcurar) {
        this.jTextField_CodigoProcurar = jTextField_CodigoProcurar;
    }

    public JTextField getjTextField_Comp1() {
        return jTextField_Comp1;
    }

    public void setjTextField_Comp1(JTextField jTextField_Comp1) {
        this.jTextField_Comp1 = jTextField_Comp1;
    }

    public JTextField getjTextField_Comp15() {
        return jTextField_Comp8;
    }

    public void setjTextField_Comp15(JTextField jTextField_Comp15) {
        this.jTextField_Comp8 = jTextField_Comp15;
    }

    public JTextField getjTextField_Comp16() {
        return jTextField_Comp9;
    }

    public void setjTextField_Comp16(JTextField jTextField_Comp16) {
        this.jTextField_Comp9 = jTextField_Comp16;
    }

    public JTextField getjTextField_Comp17() {
        return jTextField_Comp10;
    }

    public void setjTextField_Comp17(JTextField jTextField_Comp17) {
        this.jTextField_Comp10 = jTextField_Comp17;
    }

    public JTextField getjTextField_Comp18() {
        return jTextField_Comp11;
    }

    public void setjTextField_Comp18(JTextField jTextField_Comp18) {
        this.jTextField_Comp11 = jTextField_Comp18;
    }

    public JTextField getjTextField_Comp19() {
        return jTextField_Comp12;
    }

    public void setjTextField_Comp19(JTextField jTextField_Comp19) {
        this.jTextField_Comp12 = jTextField_Comp19;
    }

    public JTextField getjTextField_Comp2() {
        return jTextField_Comp2;
    }

    public void setjTextField_Comp2(JTextField jTextField_Comp2) {
        this.jTextField_Comp2 = jTextField_Comp2;
    }

    public JTextField getjTextField_Comp20() {
        return jTextField_Comp13;
    }

    public void setjTextField_Comp20(JTextField jTextField_Comp20) {
        this.jTextField_Comp13 = jTextField_Comp20;
    }

    public JTextField getjTextField_Comp21() {
        return jTextField_Comp14;
    }

    public void setjTextField_Comp21(JTextField jTextField_Comp21) {
        this.jTextField_Comp14 = jTextField_Comp21;
    }

    public JTextField getjTextField_Comp3() {
        return jTextField_Comp3;
    }

    public void setjTextField_Comp3(JTextField jTextField_Comp3) {
        this.jTextField_Comp3 = jTextField_Comp3;
    }

    public JTextField getjTextField_Comp4() {
        return jTextField_Comp4;
    }

    public void setjTextField_Comp4(JTextField jTextField_Comp4) {
        this.jTextField_Comp4 = jTextField_Comp4;
    }

    public JTextField getjTextField_Comp5() {
        return jTextField_Comp5;
    }

    public void setjTextField_Comp5(JTextField jTextField_Comp5) {
        this.jTextField_Comp5 = jTextField_Comp5;
    }

    public JTextField getjTextField_Comp6() {
        return jTextField_Comp6;
    }

    public void setjTextField_Comp6(JTextField jTextField_Comp6) {
        this.jTextField_Comp6 = jTextField_Comp6;
    }

    public JTextField getjTextField_Comp7() {
        return jTextField_Comp7;
    }

    public void setjTextField_Comp7(JTextField jTextField_Comp7) {
        this.jTextField_Comp7 = jTextField_Comp7;
    }

    public JTextField getjTextField_Diferencial1() {
        return jTextField_Diferencial1;
    }

    public void setjTextField_Diferencial1(JTextField jTextField_Diferencial1) {
        this.jTextField_Diferencial1 = jTextField_Diferencial1;
    }

    public JTextField getjTextField_Diferencial6() {
        return jTextField_Diferencial2;
    }

    public void setjTextField_Diferencial6(JTextField jTextField_Diferencial6) {
        this.jTextField_Diferencial2 = jTextField_Diferencial6;
    }

    public JTextField getjTextField_Diferencial7() {
        return jTextField_Diferencial3;
    }

    public void setjTextField_Diferencial7(JTextField jTextField_Diferencial7) {
        this.jTextField_Diferencial3 = jTextField_Diferencial7;
    }

    public JTextField getjTextField_Diferencial8() {
        return jTextField_Diferencial4;
    }

    public void setjTextField_Diferencial8(JTextField jTextField_Diferencial8) {
        this.jTextField_Diferencial4 = jTextField_Diferencial8;
    }

    public JTextField getjTextField_Diferencial9() {
        return jTextField_Diferencial5;
    }

    public void setjTextField_Diferencial9(JTextField jTextField_Diferencial9) {
        this.jTextField_Diferencial5 = jTextField_Diferencial9;
    }

    public JTextField getjTextField_EstruturaBase() {
        return jTextField_EstruturaBase;
    }

    public void setjTextField_EstruturaBase(JTextField jTextField_EstruturaBase) {
        this.jTextField_EstruturaBase = jTextField_EstruturaBase;
    }

    public JTextField getjTextField_GarantiaBase() {
        return jTextField_GarantiaBase;
    }

    public void setjTextField_GarantiaBase(JTextField jTextField_GarantiaBase) {
        this.jTextField_GarantiaBase = jTextField_GarantiaBase;
    }

    public JTextField getjTextField_GarantiaColchao() {
        return jTextField_GarantiaColchao;
    }

    public void setjTextField_GarantiaColchao(JTextField jTextField_GarantiaColchao) {
        this.jTextField_GarantiaColchao = jTextField_GarantiaColchao;
    }

    public JTextField getjTextField_Molejo() {
        return jTextField_Molejo;
    }

    public void setjTextField_Molejo(JTextField jTextField_Molejo) {
        this.jTextField_Molejo = jTextField_Molejo;
    }

    public JTextField getjTextField_NivelConforto() {
        return jTextField_NivelConforto;
    }

    public void setjTextField_NivelConforto(JTextField jTextField_NivelConforto) {
        this.jTextField_NivelConforto = jTextField_NivelConforto;
    }

    public JTextField getjTextField_NomeColchao() {
        return jTextField_NomeColchao;
    }

    public void setjTextField_NomeColchao(JTextField jTextField_NomeColchao) {
        this.jTextField_NomeColchao = jTextField_NomeColchao;
    }

    public JTextField getjTextField_Pes() {
        return jTextField_Pes;
    }

    public void setjTextField_Pes(JTextField jTextField_Pes) {
        this.jTextField_Pes = jTextField_Pes;
    }

    public JTextField getjTextField_PillowEuro() {
        return jTextField_PillowEuro;
    }

    public void setjTextField_PillowEuro(JTextField jTextField_PillowEuro) {
        this.jTextField_PillowEuro = jTextField_PillowEuro;
    }

    public JTextField getjTextField_RevestInferior() {
        return jTextField_RevestInferior;
    }

    public void setjTextField_RevestInferior(JTextField jTextField_RevestInferior) {
        this.jTextField_RevestInferior = jTextField_RevestInferior;
    }

    public JTextField getjTextField_RevestLatBase() {
        return jTextField_RevestLatBase;
    }

    public void setjTextField_RevestLatBase(JTextField jTextField_RevestLatBase) {
        this.jTextField_RevestLatBase = jTextField_RevestLatBase;
    }

    public JTextField getjTextField_RevestLateral() {
        return jTextField_RevestLateral;
    }

    public void setjTextField_RevestLateral(JTextField jTextField_RevestLateral) {
        this.jTextField_RevestLateral = jTextField_RevestLateral;
    }

    public JTextField getjTextField_RevestSupBase() {
        return jTextField_RevestSupBase;
    }

    public void setjTextField_RevestSupBase(JTextField jTextField_RevestSupBase) {
        this.jTextField_RevestSupBase = jTextField_RevestSupBase;
    }

    public JTextField getjTextField_RevestSuperior() {
        return jTextField_RevestSuperior;
    }

    public void setjTextField_RevestSuperior(JTextField jTextField_RevestSuperior) {
        this.jTextField_RevestSuperior = jTextField_RevestSuperior;
    }

    public JTextField getjTextField_SuportePeso() {
        return jTextField_SuportePeso;
    }

    public void setjTextField_SuportePeso(JTextField jTextField_SuportePeso) {
        this.jTextField_SuportePeso = jTextField_SuportePeso;
    }

    public JPanel getProcurar_botao() {
        return procurar_botao;
    }

    public void setProcurar_botao(JPanel procurar_botao) {
        this.procurar_botao = procurar_botao;
    }

    public JLabel getProcurar_txt() {
        return procurar_txt;
    }

    public void setProcurar_txt(JLabel procurar_txt) {
        this.procurar_txt = procurar_txt;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atualizar_botao;
    private javax.swing.JLabel atualizar_txt;
    private javax.swing.JButton jButton_Adicionar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Imagem;
    private javax.swing.JPanel jPanel4_fundoAzul;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_AltBase;
    private javax.swing.JTextField jTextField_AltColchao;
    private javax.swing.JTextField jTextField_AltPes;
    private javax.swing.JTextField jTextField_AltTotalConjunto;
    private javax.swing.JTextField jTextField_Caminho;
    private javax.swing.JTextField jTextField_Codigo;
    private javax.swing.JTextField jTextField_CodigoProcurar;
    private javax.swing.JTextField jTextField_Comp1;
    private javax.swing.JTextField jTextField_Comp10;
    private javax.swing.JTextField jTextField_Comp11;
    private javax.swing.JTextField jTextField_Comp12;
    private javax.swing.JTextField jTextField_Comp13;
    private javax.swing.JTextField jTextField_Comp14;
    private javax.swing.JTextField jTextField_Comp2;
    private javax.swing.JTextField jTextField_Comp3;
    private javax.swing.JTextField jTextField_Comp4;
    private javax.swing.JTextField jTextField_Comp5;
    private javax.swing.JTextField jTextField_Comp6;
    private javax.swing.JTextField jTextField_Comp7;
    private javax.swing.JTextField jTextField_Comp8;
    private javax.swing.JTextField jTextField_Comp9;
    private javax.swing.JTextField jTextField_Diferencial1;
    private javax.swing.JTextField jTextField_Diferencial2;
    private javax.swing.JTextField jTextField_Diferencial3;
    private javax.swing.JTextField jTextField_Diferencial4;
    private javax.swing.JTextField jTextField_Diferencial5;
    private javax.swing.JTextField jTextField_EstruturaBase;
    private javax.swing.JTextField jTextField_GarantiaBase;
    private javax.swing.JTextField jTextField_GarantiaColchao;
    private javax.swing.JTextField jTextField_Molejo;
    private javax.swing.JTextField jTextField_NivelConforto;
    private javax.swing.JTextField jTextField_NomeColchao;
    private javax.swing.JTextField jTextField_Pes;
    private javax.swing.JTextField jTextField_PillowEuro;
    private javax.swing.JTextField jTextField_RevestInferior;
    private javax.swing.JTextField jTextField_RevestLatBase;
    private javax.swing.JTextField jTextField_RevestLateral;
    private javax.swing.JTextField jTextField_RevestSupBase;
    private javax.swing.JTextField jTextField_RevestSuperior;
    private javax.swing.JTextField jTextField_SuportePeso;
    private javax.swing.JPanel procurar_botao;
    private javax.swing.JLabel procurar_txt;
    // End of variables declaration//GEN-END:variables
}
