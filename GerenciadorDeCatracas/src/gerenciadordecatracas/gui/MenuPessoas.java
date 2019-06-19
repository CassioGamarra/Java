/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordecatracas.gui;

import gerenciadordecatracas.gerenciamento.Cadastro;
import gerenciadordecatracas.gerenciamento.CadastroValidator;
import gerenciadordecatracas.gerenciamento.Utilitario;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gnomo
 */
public class MenuPessoas extends javax.swing.JFrame {

    public MenuPessoas() {
        initComponents();
    }

    public JTextField getCampoCPF() {
        return campoCPF;
    }

    public void setCampoCPF(JFormattedTextField campoCPF) {
        this.campoCPF = campoCPF;
    }
    
    //Classes utilizadas
    Cadastro cadastro = new Cadastro();
    CadastroValidator cadastroValidator = new CadastroValidator();
    Utilitario util = new Utilitario();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameCadastro = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        ComboBoxCategoria = new javax.swing.JComboBox<>();
        campoCategoria = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 32767));
        campoCPF = new javax.swing.JFormattedTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        frameConsulsta = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        campoConsulta = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnCancelarCon = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        frameExcluir = new javax.swing.JFrame();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoConsultaExclusao = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        btnVoltarExc = new javax.swing.JButton();
        dialogConsulta = new javax.swing.JDialog();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnVoltarDialog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoConsulta = new javax.swing.JTextArea();
        frameExclusao = new javax.swing.JFrame();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoExclusao = new javax.swing.JTextArea();
        btnExcluir = new javax.swing.JButton();
        btnCancelarExclusao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIncluirPessoa = new javax.swing.JButton();
        btnExcluirPessoa = new javax.swing.JButton();
        btnConsultarPessoa = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        frameCadastro.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frameCadastro.setTitle("PROJETO FINAL V1.1 - CADASTRAR");
        frameCadastro.setBackground(new java.awt.Color(0, 0, 0));
        frameCadastro.setForeground(java.awt.Color.white);
        frameCadastro.setMinimumSize(new java.awt.Dimension(400, 530));
        frameCadastro.setLocationRelativeTo(null);
        frameCadastro.setPreferredSize(new java.awt.Dimension(400, 530));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CADASTRO DE PESSOAS");

        campoNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        ComboBoxCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Responsável", "Colaborador", "Visitante" }));
        ComboBoxCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        ComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCategoriaActionPerformed(evt);
            }
        });

        campoCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        campoCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCategoriaKeyPressed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        campoCPF.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPF.setText("000.000.000-00");
        campoCPF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });

        campoTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TELEFONE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setText("(00)0 0000-0000");
        campoTelefone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        if(campoTelefone.getText().length()==8){
            try{
                campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
            }
            catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

        }

        javax.swing.GroupLayout frameCadastroLayout = new javax.swing.GroupLayout(frameCadastro.getContentPane());
        frameCadastro.getContentPane().setLayout(frameCadastroLayout);
        frameCadastroLayout.setHorizontalGroup(
            frameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(frameCadastroLayout.createSequentialGroup()
                .addGroup(frameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameCadastroLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(frameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(frameCadastroLayout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(campoNome)
                        .addComponent(campoCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                        .addComponent(campoCategoria, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameCadastroLayout.setVerticalGroup(
            frameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        frameConsulsta.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frameConsulsta.setTitle("PROJETO FINAL  - CONSULTAR");
        frameConsulsta.setForeground(java.awt.Color.white);
        frameConsulsta.setMinimumSize(new java.awt.Dimension(340, 280));
        frameConsulsta.setLocationRelativeTo(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("CÓDIGO:");

        campoConsulta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoConsultaKeyPressed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCancelarCon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelarCon.setText("CANCELAR");
        btnCancelarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CONSULTAR PESSOA");

        javax.swing.GroupLayout frameConsulstaLayout = new javax.swing.GroupLayout(frameConsulsta.getContentPane());
        frameConsulsta.getContentPane().setLayout(frameConsulstaLayout);
        frameConsulstaLayout.setHorizontalGroup(
            frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameConsulstaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameConsulstaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(frameConsulstaLayout.createSequentialGroup()
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(btnCancelarCon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameConsulstaLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoConsulta)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        frameConsulstaLayout.setVerticalGroup(
            frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameConsulstaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameConsulstaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnCancelarCon))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        frameExcluir.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameExcluir.setTitle("PROJETO FINAL  - EXCLUIR");
        frameExcluir.setForeground(java.awt.Color.white);
        frameExcluir.setMinimumSize(new java.awt.Dimension(340, 280));
        frameExcluir.setResizable(false);
        frameExcluir.setLocationRelativeTo(null);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXCLUIR PESSOA");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("CÓDIGO:");

        campoConsultaExclusao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoConsultaExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoConsultaExclusaoActionPerformed(evt);
            }
        });
        campoConsultaExclusao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoConsultaExclusaoKeyPressed(evt);
            }
        });

        btnVerificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnVoltarExc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltarExc.setText("VOLTAR");
        btnVoltarExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarExcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameExcluirLayout = new javax.swing.GroupLayout(frameExcluir.getContentPane());
        frameExcluir.getContentPane().setLayout(frameExcluirLayout);
        frameExcluirLayout.setHorizontalGroup(
            frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameExcluirLayout.createSequentialGroup()
                        .addComponent(btnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnVoltarExc, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, frameExcluirLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoConsultaExclusao)))
                .addContainerGap())
        );
        frameExcluirLayout.setVerticalGroup(
            frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoConsultaExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerificar)
                    .addComponent(btnVoltarExc))
                .addGap(50, 50, 50))
        );

        dialogConsulta.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogConsulta.setTitle("RESULTADO CONSULTA");
        dialogConsulta.setAlwaysOnTop(true);
        dialogConsulta.setMinimumSize(new java.awt.Dimension(350, 400));
        dialogConsulta.setLocationRelativeTo(null);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("DADOS CADASTRADOS");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        btnVoltarDialog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltarDialog.setText("VOLTAR");
        btnVoltarDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarDialogActionPerformed(evt);
            }
        });

        textoConsulta.setColumns(20);
        textoConsulta.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        textoConsulta.setRows(5);
        jScrollPane1.setViewportView(textoConsulta);
        textoConsulta.setEditable(false);

        javax.swing.GroupLayout dialogConsultaLayout = new javax.swing.GroupLayout(dialogConsulta.getContentPane());
        dialogConsulta.getContentPane().setLayout(dialogConsultaLayout);
        dialogConsultaLayout.setHorizontalGroup(
            dialogConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(dialogConsultaLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnVoltarDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogConsultaLayout.setVerticalGroup(
            dialogConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltarDialog)
                .addContainerGap())
        );

        btnVoltarDialog.getAccessibleContext().setAccessibleName("OK");

        frameExclusao.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameExclusao.setTitle("PROJETO FINAL V1.1 - EXCLUIR");
        frameExclusao.setForeground(java.awt.Color.white);
        frameExclusao.setMinimumSize(new java.awt.Dimension(350, 400));
        frameExclusao.setResizable(false);
        frameExclusao.setLocationRelativeTo(null);
        frameExclusao.getRootPane().setDefaultButton(btnExcluir);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DADOS USUÁRIO");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        textoExclusao.setEditable(false);
        textoExclusao.setColumns(20);
        textoExclusao.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        textoExclusao.setRows(5);
        jScrollPane3.setViewportView(textoExclusao);
        textoConsulta.setEditable(false);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelarExclusao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelarExclusao.setText("CANCELAR");
        btnCancelarExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarExclusaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameExclusaoLayout = new javax.swing.GroupLayout(frameExclusao.getContentPane());
        frameExclusao.getContentPane().setLayout(frameExclusaoLayout);
        frameExclusaoLayout.setHorizontalGroup(
            frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExclusaoLayout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarExclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExclusaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        frameExclusaoLayout.setVerticalGroup(
            frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameExclusaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelarExclusao))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROJETO FINAL  - PESSOAS");
        setMinimumSize(new java.awt.Dimension(239, 280));
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gerenciadordecatracas/gui/pessoa.png"))); // NOI18N

        btnIncluirPessoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIncluirPessoa.setText("INCLUIR PESSOA");
        btnIncluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirPessoaActionPerformed(evt);
            }
        });

        btnExcluirPessoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcluirPessoa.setText("EXCLUIR PESSOA");
        btnExcluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPessoaActionPerformed(evt);
            }
        });

        btnConsultarPessoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConsultarPessoa.setText("CONSULTAR PESSOA");
        btnConsultarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPessoaActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluirPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIncluirPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        MenuPessoas.this.dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnIncluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirPessoaActionPerformed
        frameCadastro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIncluirPessoaActionPerformed
    
    public JDialog getDialogConsulta() {
        return dialogConsulta;
    }

    public void setDialogConsulta(JDialog dialogConsulta) {
        this.dialogConsulta = dialogConsulta;
    }

    public JTextArea getTextoConsulta() {
        return textoConsulta;
    }

    public void setTextoConsulta(JTextArea textoConsulta) {
        this.textoConsulta = textoConsulta;
    }

    public JButton getBtnVerificar() {
        return btnVerificar;
    }

    public JFrame getFrameConsultar() {
        return frameConsulsta;
    }

    public void setFrameConsultar(JFrame frameConsultar) {
        this.frameConsulsta = frameConsultar;
    }

    public JFrame getFrameExcluir() {
        return frameExcluir;
    }

    public void setFrameExcluir(JFrame frameExcluir) {
        this.frameExcluir = frameExcluir;
    }

    public void setBtnVerificar(JButton btnVerificar) {
        this.btnVerificar = btnVerificar;
    }

    public JTextField getCampoConsulta() {
        return campoConsulta;
    }

    public void setCampoConsulta(JTextField campoConsulta) {
        this.campoConsulta = campoConsulta;
    }

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed
    
    //ALTERA O TITULO DO CAMPO CATEGORIA DE ACORDO COM O COMBOBOX
    private void ComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCategoriaActionPerformed
        String nomeCampo = "";
        if(getComboBoxCategoria().getSelectedItem() == "Aluno"){
            nomeCampo = "TURMA";
        }
        if(getComboBoxCategoria().getSelectedItem() == "Responsável"){
            nomeCampo = "DEPENDENTES";
        }
        if(getComboBoxCategoria().getSelectedItem() == "Colaborador"){
            nomeCampo = "CARGO";
        }
        if(getComboBoxCategoria().getSelectedItem() == "Visitante"){
            nomeCampo = "OBSERVAÇÕES";
        }
        campoCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, nomeCampo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18)));
    }//GEN-LAST:event_ComboBoxCategoriaActionPerformed

    public JTextField getCampoCategoria() {
        return campoCategoria;
    }

    public void setCampoCategoria(JTextField campoCategoria) {
        this.campoCategoria = campoCategoria;
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(JTextField campoNome) {
        this.campoNome = campoNome;
    }

    public JFormattedTextField getCampoTelefone() {
        return campoTelefone;
    }

    public void setCampoTelefone(JFormattedTextField campoTelefone) {
        this.campoTelefone = campoTelefone;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            frameCadastro.dispose();
            new MenuPessoas().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public JTextField getCampoConsultaExclusao() {
        return campoConsultaExclusao;
    }

    public void setCampoConsultaExclusao(JTextField campoConsultaExclusao) {
        this.campoConsultaExclusao = campoConsultaExclusao;
    }

    public JFrame getFrameExclusao() {
        return frameExclusao;
    }

    public void setFrameExclusao(JFrame frameExclusao) {
        this.frameExclusao = frameExclusao;
    }

    public JTextArea getTextoExclusao() {
        return textoExclusao;
    }

    public void setTextoExclusao(JTextArea textoExclusao) {
        this.textoExclusao = textoExclusao;
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        cadastroValidator.validarCadastro(this);
    }//GEN-LAST:event_btnSalvarActionPerformed

    public JFrame getFrameCadastrar() {
        return frameCadastro;
    }

    public void setFrameCadastrar(JFrame frameCadastrar) {
        this.frameCadastro = frameCadastrar;
    }

    private void btnConsultarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPessoaActionPerformed
        frameConsulsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultarPessoaActionPerformed

    private void btnExcluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPessoaActionPerformed
        frameExcluir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExcluirPessoaActionPerformed

    private void btnVoltarDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarDialogActionPerformed
        dialogConsulta.dispose();
        frameConsulsta.setVisible(true);
    }//GEN-LAST:event_btnVoltarDialogActionPerformed

    private void btnVoltarExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarExcActionPerformed
        frameExcluir.dispose();
        new MenuPessoas().setVisible(true);
    }//GEN-LAST:event_btnVoltarExcActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        cadastroValidator.consultarExclusao(this);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void campoConsultaExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoConsultaExclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoConsultaExclusaoActionPerformed

    private void btnCancelarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConActionPerformed
        frameConsulsta.dispose();
        new MenuPessoas().setVisible(true);
    }//GEN-LAST:event_btnCancelarConActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        cadastroValidator.validarConsulta(this);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        cadastro.excluir(this);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarExclusaoActionPerformed
        frameExclusao.dispose();
        util.limparFrame(frameExcluir);
        frameExcluir.setVisible(true);
    }//GEN-LAST:event_btnCancelarExclusaoActionPerformed

    private void campoCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCategoriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {                    
            btnSalvar.doClick();
        }
    }//GEN-LAST:event_campoCategoriaKeyPressed

    private void campoConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConsultaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {                    
            btnConsultar.doClick();
        }
    }//GEN-LAST:event_campoConsultaKeyPressed

    private void campoConsultaExclusaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoConsultaExclusaoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {                    
            btnVerificar.doClick();
        }
    }//GEN-LAST:event_campoConsultaExclusaoKeyPressed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCPFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPessoas().setVisible(true);
            }
        });
    }

    public JComboBox<String> getComboBoxCategoria() {
        return ComboBoxCategoria;
    }

    public void setComboBoxCategoria(JComboBox<String> ComboBoxCategoria) {
        this.ComboBoxCategoria = ComboBoxCategoria;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCon;
    private javax.swing.JButton btnCancelarExclusao;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultarPessoa;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirPessoa;
    private javax.swing.JButton btnIncluirPessoa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltarDialog;
    private javax.swing.JButton btnVoltarExc;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoConsulta;
    private javax.swing.JTextField campoConsultaExclusao;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JDialog dialogConsulta;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JFrame frameCadastro;
    private javax.swing.JFrame frameConsulsta;
    private javax.swing.JFrame frameExcluir;
    private javax.swing.JFrame frameExclusao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textoConsulta;
    private javax.swing.JTextArea textoExclusao;
    // End of variables declaration//GEN-END:variables
}
