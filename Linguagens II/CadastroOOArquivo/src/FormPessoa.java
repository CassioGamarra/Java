
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class FormPessoa extends javax.swing.JFrame {

    
    public FormPessoa() {
        initComponents();
        setLocationRelativeTo(null); // centralizar interface gráfica
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEstadoCivil = new javax.swing.ButtonGroup();
        buttonGroupGenero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioSolteiro = new javax.swing.JRadioButton();
        jRadioCasado = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioM = new javax.swing.JRadioButton();
        jRadioF = new javax.swing.JRadioButton();
        jCheckMaior18 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jComboEscolaridade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAOutrasInformacoes = new javax.swing.JTextArea();
        jButtonCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("E-mail:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado civil", 0, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroupEstadoCivil.add(jRadioSolteiro);
        jRadioSolteiro.setText("Solteiro");

        buttonGroupEstadoCivil.add(jRadioCasado);
        jRadioCasado.setText("Casado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioSolteiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioCasado)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioSolteiro)
                    .addComponent(jRadioCasado))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gênero", 0, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroupGenero.add(jRadioM);
        jRadioM.setText("M");

        buttonGroupGenero.add(jRadioF);
        jRadioF.setText("F");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioM)
                .addGap(27, 27, 27)
                .addComponent(jRadioF)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioM)
                    .addComponent(jRadioF))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jCheckMaior18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckMaior18.setText("Maior de 18 anos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Escolaridade:");

        jTFNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNomeKeyPressed(evt);
            }
        });

        jComboEscolaridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensino fundamental", "Ensino médio", "Ensino superior" }));
        jComboEscolaridade.setSelectedIndex(-1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Outras informações:");

        jTAOutrasInformacoes.setColumns(20);
        jTAOutrasInformacoes.setLineWrap(true);
        jTAOutrasInformacoes.setRows(5);
        jScrollPane1.setViewportView(jTAOutrasInformacoes);

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckMaior18)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jButtonCadastrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckMaior18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        cadastrar();
        limparCampos();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTFNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Arquivo arquivo = new Arquivo();
            String[] vetor = arquivo.consultar(jTFNome.getText());
            jTFNome.setText(vetor[0]);
            jTFEmail.setText(vetor[1]);
            if (vetor[2].equals("Casado")) {
                jRadioCasado.setSelected(true);
            }
            else if (vetor[2].equals("Solteiro")) {
                jRadioSolteiro.setSelected(true);
            }
            if (vetor[3].equals("M")) {
                jRadioM.setSelected(true);
            }
            else if (vetor[3].equals("F")) {
                jRadioF.setSelected(true);
            }
            
            if (vetor[4].equals("Sim")) {
                jCheckMaior18.setSelected(true);
            }
            
            if (vetor[5].equals("Ensino fundamental")) {
                jComboEscolaridade.setSelectedIndex(0);
            }
            else if (vetor[5].equals("Ensino médio")) {
                jComboEscolaridade.setSelectedIndex(1);
            }
            else if (vetor[5].equals("Ensino superior")) {
                jComboEscolaridade.setSelectedIndex(2);
            }
            
            jTAOutrasInformacoes.setText(vetor[6]);
            
        }
    }//GEN-LAST:event_jTFNomeKeyPressed

    private void cadastrar() {
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(jTFNome.getText());
        pessoa.setEmail(jTFEmail.getText());
        
        if (jRadioSolteiro.isSelected()) {
            pessoa.setEstadoCivil("Solteiro");
        }
        if (jRadioCasado.isSelected()) {
            pessoa.setEstadoCivil("Casado");
        }
        
        if (jRadioM.isSelected()) {
            pessoa.setGenero("M");
        }
        if (jRadioF.isSelected()) {
            pessoa.setGenero("F");
        }
        
        if (jCheckMaior18.isSelected()) {
            pessoa.setMaior18anos("Sim");
        }
        
        pessoa.setEscolaridade(jComboEscolaridade.getSelectedItem()+"");
        pessoa.setOutrasInformacoes(jTAOutrasInformacoes.getText());
      
        Arquivo arquivo = new Arquivo();
        
        int retorno = arquivo.cadastrar(pessoa);
        if (retorno == 1) {
            JOptionPane.showMessageDialog(this, "Cadastro realizando com sucesso");
            limparCampos();
        }
        else {
            JOptionPane.showMessageDialog(this, "Erro na tentativa de cadastrar");
        }
        
        
    }
    
    private void limparCampos(){
        jTFNome.setText("");
        jTFEmail.setText("");
        buttonGroupEstadoCivil.clearSelection();
        buttonGroupGenero.clearSelection();
        jCheckMaior18.setSelected(false);
        jComboEscolaridade.setSelectedIndex(-1);
        jTAOutrasInformacoes.setText("");
    }
    
   

    
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
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupEstadoCivil;
    private javax.swing.ButtonGroup buttonGroupGenero;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JCheckBox jCheckMaior18;
    private javax.swing.JComboBox<String> jComboEscolaridade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioCasado;
    private javax.swing.JRadioButton jRadioF;
    private javax.swing.JRadioButton jRadioM;
    private javax.swing.JRadioButton jRadioSolteiro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAOutrasInformacoes;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables

}
