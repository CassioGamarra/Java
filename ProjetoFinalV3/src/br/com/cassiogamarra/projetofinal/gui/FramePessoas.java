/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cassiogamarra.projetofinal.gui;

import br.com.cassiogamarra.projetofinal.cadastro.Cadastrar;
import br.com.cassiogamarra.projetofinal.cadastro.Consultar;
import br.com.cassiogamarra.projetofinal.cadastro.Excluir;
import br.com.cassiogamarra.projetofinal.utilitarios.LimparTela;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gnomo
 */
public class FramePessoas extends javax.swing.JFrame {

    public FramePessoas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameCadastrar = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCPF = new javax.swing.JTextField();
        campoTelefone = new javax.swing.JTextField();
        ComboBoxCategoria = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        frameConsultar = new javax.swing.JFrame();
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

        frameCadastrar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameCadastrar.setTitle("PROJETO FINAL - CADASTRAR");
        frameCadastrar.setForeground(java.awt.Color.white);
        frameCadastrar.setMinimumSize(new java.awt.Dimension(375, 400));
        frameCadastrar.setLocationRelativeTo(null);
        frameCadastrar.setResizable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CADASTRO DE PESSOAS");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NOME:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONE:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CATEGORIA:");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        campoCPF.setMaximumSize(new java.awt.Dimension(6, 50));
        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });

        ComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Responsável", "Colaborador", "Visitante" }));
        ComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCategoriaActionPerformed(evt);
            }
        });

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameCadastrarLayout = new javax.swing.GroupLayout(frameCadastrar.getContentPane());
        frameCadastrar.getContentPane().setLayout(frameCadastrarLayout);
        frameCadastrarLayout.setHorizontalGroup(
            frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameCadastrarLayout.createSequentialGroup()
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameCadastrarLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnSalvar)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancelar))
                    .addGroup(frameCadastrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(lblCategoria)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 252, Short.MAX_VALUE)
                                .addComponent(campoTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoCategoria))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameCadastrarLayout.setVerticalGroup(
            frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameCadastrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(frameCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(15, 15, 15))
        );

        jLabel7.getAccessibleContext().setAccessibleDescription("");

        frameConsultar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameConsultar.setTitle("PROJETO FINAL - CONSULTAR");
        frameConsultar.setForeground(java.awt.Color.white);
        frameConsultar.setMinimumSize(new java.awt.Dimension(255, 250));
        frameConsultar.setLocationRelativeTo(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("CÓDIGO:");

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCancelarCon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelarCon.setText("CANCELAR");
        btnCancelarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CONSULTAR PESSOA");

        javax.swing.GroupLayout frameConsultarLayout = new javax.swing.GroupLayout(frameConsultar.getContentPane());
        frameConsultar.getContentPane().setLayout(frameConsultarLayout);
        frameConsultarLayout.setHorizontalGroup(
            frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameConsultarLayout.createSequentialGroup()
                .addGroup(frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameConsultarLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(frameConsultarLayout.createSequentialGroup()
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarCon))
                            .addGroup(frameConsultarLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoConsulta)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameConsultarLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addContainerGap(5, Short.MAX_VALUE))
        );
        frameConsultarLayout.setVerticalGroup(
            frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameConsultarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnCancelarCon))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        frameExcluir.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameExcluir.setTitle("PROJETO FINAL - EXCLUIR");
        frameExcluir.setForeground(java.awt.Color.white);
        frameExcluir.setMinimumSize(new java.awt.Dimension(237, 250));
        frameExcluir.setResizable(false);
        frameExcluir.setLocationRelativeTo(null);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EXCLUIR PESSOA");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("CÓDIGO:");

        campoConsultaExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoConsultaExclusaoActionPerformed(evt);
            }
        });

        btnVerificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnVoltarExc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
            .addGroup(frameExcluirLayout.createSequentialGroup()
                .addGroup(frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameExcluirLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameExcluirLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameExcluirLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameExcluirLayout.createSequentialGroup()
                                .addComponent(btnVerificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVoltarExc, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addGroup(frameExcluirLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoConsultaExclusao)))))
                .addContainerGap())
        );
        frameExcluirLayout.setVerticalGroup(
            frameExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        btnVoltarDialog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltarDialog.setText("VOLTAR");
        btnVoltarDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarDialogActionPerformed(evt);
            }
        });

        textoConsulta.setColumns(20);
        textoConsulta.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        textoConsulta.setRows(5);
        jScrollPane1.setViewportView(textoConsulta);
        textoConsulta.setEditable(false);

        javax.swing.GroupLayout dialogConsultaLayout = new javax.swing.GroupLayout(dialogConsulta.getContentPane());
        dialogConsulta.getContentPane().setLayout(dialogConsultaLayout);
        dialogConsultaLayout.setHorizontalGroup(
            dialogConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(dialogConsultaLayout.createSequentialGroup()
                .addGroup(dialogConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogConsultaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogConsultaLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel16))
                    .addGroup(dialogConsultaLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnVoltarDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogConsultaLayout.setVerticalGroup(
            dialogConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogConsultaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltarDialog)
                .addContainerGap())
        );

        btnVoltarDialog.getAccessibleContext().setAccessibleName("OK");

        frameExclusao.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameExclusao.setTitle("PROJETO FINAL - EXCLUIR");
        frameExclusao.setForeground(java.awt.Color.white);
        frameExclusao.setMinimumSize(new java.awt.Dimension(350, 400));
        frameExclusao.setResizable(false);
        frameExclusao.setLocationRelativeTo(null);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DADOS USUÁRIO");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        textoExclusao.setEditable(false);
        textoExclusao.setColumns(20);
        textoExclusao.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        textoExclusao.setRows(5);
        jScrollPane3.setViewportView(textoExclusao);
        textoConsulta.setEditable(false);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelarExclusao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
            .addGroup(frameExclusaoLayout.createSequentialGroup()
                .addGroup(frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameExclusaoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameExclusaoLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel25)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameExclusaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarExclusao)
                .addGap(56, 56, 56))
        );
        frameExclusaoLayout.setVerticalGroup(
            frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameExclusaoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameExclusaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelarExclusao))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROJETO FINAL - PESSOAS");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cassiogamarra/projetofinal/gui/pessoa.png"))); // NOI18N

        btnIncluirPessoa.setText("INCLUIR PESSOA");
        btnIncluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirPessoaActionPerformed(evt);
            }
        });

        btnExcluirPessoa.setText("EXCLUIR PESSOA");
        btnExcluirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPessoaActionPerformed(evt);
            }
        });

        btnConsultarPessoa.setText("CONSULTAR PESSOA");
        btnConsultarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPessoaActionPerformed(evt);
            }
        });

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIncluirPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(btnConsultarPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        FramePessoas.this.dispose();
        new FrameInicio().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnIncluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirPessoaActionPerformed
        frameCadastrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIncluirPessoaActionPerformed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCPFActionPerformed

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

    private void ComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCategoriaActionPerformed
        //MÉTODO PARA ALTERAR O NOME DO COMBOBOX
        AlterarComboBox.alterarComboBox(this);
    }//GEN-LAST:event_ComboBoxCategoriaActionPerformed

    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    public JTextField getCampoCPF() {
        return campoCPF;
    }

    public void setCampoCPF(JTextField campoCPF) {
        this.campoCPF = campoCPF;
    }

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

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public void setCampoTelefone(JTextField campoTelefone) {
        this.campoTelefone = campoTelefone;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            frameCadastrar.dispose();
            new FramePessoas().setVisible(true);
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
        try {
            //MÉTODO PARA VALIDAR O CADASTRO
            Cadastrar.validarCadastro(this);
        } catch (SQLException ex) {
            Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public JFrame getFrameCadastrar() {
        return frameCadastrar;
    }

    public void setFrameCadastrar(JFrame frameCadastrar) {
        this.frameCadastrar = frameCadastrar;
    }

    private void btnConsultarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPessoaActionPerformed
        frameConsultar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultarPessoaActionPerformed

    private void btnExcluirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPessoaActionPerformed
        frameExcluir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExcluirPessoaActionPerformed

    private void btnVoltarDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarDialogActionPerformed
        dialogConsulta.dispose();
        frameConsultar.setVisible(true);
    }//GEN-LAST:event_btnVoltarDialogActionPerformed

    private void btnVoltarExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarExcActionPerformed
        frameExcluir.dispose();
        new FramePessoas().setVisible(true);
    }//GEN-LAST:event_btnVoltarExcActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        Excluir.verificarExclusao(this);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void campoConsultaExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoConsultaExclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoConsultaExclusaoActionPerformed

    private void btnCancelarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConActionPerformed
        frameConsultar.dispose();
        new FramePessoas().setVisible(true);
    }//GEN-LAST:event_btnCancelarConActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Consultar.validarConsulta(this);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            //METODO EXCLUIR
            Excluir.excluir(this);
        } catch (SQLException ex) {
            Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarExclusaoActionPerformed
        frameExclusao.dispose();
        frameExcluir.setVisible(true);
    }//GEN-LAST:event_btnCancelarExclusaoActionPerformed

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
            java.util.logging.Logger.getLogger(FramePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePessoas().setVisible(true);
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
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoConsulta;
    private javax.swing.JTextField campoConsultaExclusao;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JDialog dialogConsulta;
    private javax.swing.JFrame frameCadastrar;
    private javax.swing.JFrame frameConsultar;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JTextArea textoConsulta;
    private javax.swing.JTextArea textoExclusao;
    // End of variables declaration//GEN-END:variables
}
