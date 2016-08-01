/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisplanperguntas;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte
 */
public class CadPerguntas extends javax.swing.JFrame {

    /**
     * Creates new form CadPerguntas
     */
    public CadPerguntas() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration()); 

         Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 

          int width = d.width-(in.left + in.top); 
          int height = d.height-(in.top + in.bottom); 
          setSize(width,height); 
          setLocation(in.left,in.top);
          
          jTPergunta.grabFocus();
         
        
        
         Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Perguntas.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CADPERGUNTAS;");

           
            
            while (resultSet.next()) {
                int numero = resultSet.getInt("NUMERO");
                
                jTNumeroPerg.setText(Integer.toString(numero + 1));
                
            }
            resultSet.close();
            statement.close();            
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + "erro na consulta de pacientes botão consultar " + e.getMessage());
            System.exit(0);
        }
        
       
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Perguntas.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CADGRUPOS;");

          
            
            while (resultSet.next()) {
                
                String desc = resultSet.getString("DESCRICAO");
                
                jCBGrupoPergun.addItem(desc);
                
            }
            resultSet.close();
            statement.close();            
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + "erro na consulta de pacientes botão consultar " + e.getMessage());
            System.exit(0);
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

        jPPerguntas_cadastro = new javax.swing.JPanel();
        jTPergunta = new javax.swing.JTextField();
        jTNumeroPerg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCBGrupoPergun = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jCBNivel = new javax.swing.JComboBox();
        jPAlternativas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTAlterna1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTAlterna2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTAlterna3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTAlterna4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTAlterna5 = new javax.swing.JTextField();
        jCBResposta1 = new javax.swing.JRadioButton();
        jCBResposta2 = new javax.swing.JRadioButton();
        jCBResposta3 = new javax.swing.JRadioButton();
        jCBResposta4 = new javax.swing.JRadioButton();
        jCBResposta5 = new javax.swing.JRadioButton();
        Grava = new javax.swing.JButton();
        fecha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPPerguntas_cadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perguntas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel6.setText("Codigo:");

        jLabel7.setText("Pergunta:");

        jLabel8.setText("Grupo");

        jCBGrupoPergun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBGrupoPergun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGrupoPergunActionPerformed(evt);
            }
        });

        jLabel9.setText("Nivel");

        jCBNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Fácil", "Médio", "Difícil" }));

        javax.swing.GroupLayout jPPerguntas_cadastroLayout = new javax.swing.GroupLayout(jPPerguntas_cadastro);
        jPPerguntas_cadastro.setLayout(jPPerguntas_cadastroLayout);
        jPPerguntas_cadastroLayout.setHorizontalGroup(
            jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerguntas_cadastroLayout.createSequentialGroup()
                .addGroup(jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPerguntas_cadastroLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(jPPerguntas_cadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPergunta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPPerguntas_cadastroLayout.createSequentialGroup()
                        .addComponent(jTNumeroPerg, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBGrupoPergun, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPPerguntas_cadastroLayout.setVerticalGroup(
            jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPerguntas_cadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNumeroPerg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jCBGrupoPergun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jCBNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPPerguntas_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPAlternativas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alternativas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("1-");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("2-");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("3-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("4-");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("5-");

        jCBResposta1.setText("Certa");
        jCBResposta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBResposta1ActionPerformed(evt);
            }
        });

        jCBResposta2.setText("Certa");
        jCBResposta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBResposta2ActionPerformed(evt);
            }
        });

        jCBResposta3.setText("Certa");
        jCBResposta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBResposta3ActionPerformed(evt);
            }
        });

        jCBResposta4.setText("Certa");
        jCBResposta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBResposta4ActionPerformed(evt);
            }
        });

        jCBResposta5.setText("Certa");
        jCBResposta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBResposta5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAlternativasLayout = new javax.swing.GroupLayout(jPAlternativas);
        jPAlternativas.setLayout(jPAlternativasLayout);
        jPAlternativasLayout.setHorizontalGroup(
            jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAlternativasLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPAlternativasLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTAlterna5))
                    .addGroup(jPAlternativasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTAlterna4))
                    .addGroup(jPAlternativasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTAlterna3))
                    .addGroup(jPAlternativasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTAlterna2))
                    .addGroup(jPAlternativasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTAlterna1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBResposta1)
                    .addComponent(jCBResposta2)
                    .addComponent(jCBResposta3)
                    .addComponent(jCBResposta4)
                    .addComponent(jCBResposta5))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPAlternativasLayout.setVerticalGroup(
            jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAlternativasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTAlterna1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBResposta1))
                .addGap(18, 18, 18)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTAlterna2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBResposta2))
                .addGap(23, 23, 23)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTAlterna3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBResposta3))
                .addGap(25, 25, 25)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTAlterna4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBResposta4))
                .addGap(25, 25, 25)
                .addGroup(jPAlternativasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTAlterna5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBResposta5))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        Grava.setText("Gravar");
        Grava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravaActionPerformed(evt);
            }
        });

        fecha.setText("Fechar");
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Grava, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(jPAlternativas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPPerguntas_cadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPerguntas_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPAlternativas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Grava, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravaActionPerformed
       String pergunta = jTPergunta.getText();
       String alternativa1 = jTAlterna1.getText();
       String alternativa2 = jTAlterna2.getText();
       String alternativa3 = jTAlterna3.getText();
       String alternativa4 = jTAlterna4.getText();
       String alternativa5 = jTAlterna5.getText();
       String certa1;
       String certa2;
       String certa3;
       String certa4;
       String certa5;
       String nivel = (String) jCBNivel.getSelectedItem();
               
       if (jCBResposta1.isSelected()){
           certa1 = "Certa";
       }else{
           certa1 = "Errada";
       }
       if (jCBResposta2.isSelected()){
           certa2 = "Certa";
       }else{
           certa2 = "Errada";
       }
       if (jCBResposta3.isSelected()){
           certa3 = "Certa";
       }else{
           certa3 = "Errada";
       }
       if (jCBResposta4.isSelected()){
           certa4 = "Certa";
       }else{
           certa4 = "Errada";
       }
       if (jCBResposta5.isSelected()){
           certa5 = "Certa";
       }else{
           certa5 = "Errada";
       }
       
        CadPergunta novoCadPergunta;
        novoCadPergunta = new CadPergunta(pergunta, alternativa1, alternativa2, alternativa3, alternativa4, alternativa5, certa1, certa2, certa3, certa4, certa5, nivel);
        CadastroCadPergunta.Cadastrar(pergunta, alternativa1, alternativa2, alternativa3, alternativa4, alternativa5, certa1, certa2, certa3, certa4, certa5, nivel);
        
       jTPergunta.setText("");
       jTAlterna1.setText("");
       jTAlterna2.setText("");
       jTAlterna3.setText("");
       jTAlterna4.setText("");
       jTAlterna5.setText("");
       jCBResposta1.setSelected(false);
       jCBResposta2.setSelected(false);
       jCBResposta3.setSelected(false);
       jCBResposta4.setSelected(false);
       jCBResposta5.setSelected(false);
       jCBGrupoPergun.setSelectedItem("");
       jCBNivel.setSelectedItem("");
        
        JOptionPane.showMessageDialog(null, "Informação gravada com sucesso!");
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Perguntas.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CADPERGUNTAS;");

           
            
            while (resultSet.next()) {
                int numero = resultSet.getInt("NUMERO");
                
                jTNumeroPerg.setText(Integer.toString(numero + 1));
                
            }
            resultSet.close();
            statement.close();            
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + "erro na consulta de pacientes botão consultar " + e.getMessage());
            System.exit(0);
        }
    }//GEN-LAST:event_GravaActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_fechaActionPerformed

    private void jCBResposta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBResposta1ActionPerformed
        jCBResposta2.setSelected(false);
        jCBResposta3.setSelected(false);
        jCBResposta4.setSelected(false);
        jCBResposta5.setSelected(false);
    }//GEN-LAST:event_jCBResposta1ActionPerformed

    private void jCBResposta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBResposta2ActionPerformed
        jCBResposta1.setSelected(false);
        jCBResposta3.setSelected(false);
        jCBResposta4.setSelected(false);
        jCBResposta5.setSelected(false);
    }//GEN-LAST:event_jCBResposta2ActionPerformed

    private void jCBResposta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBResposta3ActionPerformed
        jCBResposta1.setSelected(false);
        jCBResposta2.setSelected(false);
        jCBResposta4.setSelected(false);
        jCBResposta5.setSelected(false);
    }//GEN-LAST:event_jCBResposta3ActionPerformed

    private void jCBResposta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBResposta4ActionPerformed
        jCBResposta1.setSelected(false);
        jCBResposta2.setSelected(false);
        jCBResposta3.setSelected(false);
        jCBResposta5.setSelected(false);
    }//GEN-LAST:event_jCBResposta4ActionPerformed

    private void jCBResposta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBResposta5ActionPerformed
        jCBResposta1.setSelected(false);
        jCBResposta2.setSelected(false);
        jCBResposta3.setSelected(false);
        jCBResposta4.setSelected(false);
    }//GEN-LAST:event_jCBResposta5ActionPerformed

    private void jCBGrupoPergunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGrupoPergunActionPerformed
        
    }//GEN-LAST:event_jCBGrupoPergunActionPerformed

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
            java.util.logging.Logger.getLogger(CadPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPerguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Grava;
    private javax.swing.JButton fecha;
    private javax.swing.JComboBox jCBGrupoPergun;
    private javax.swing.JComboBox jCBNivel;
    private javax.swing.JRadioButton jCBResposta1;
    private javax.swing.JRadioButton jCBResposta2;
    private javax.swing.JRadioButton jCBResposta3;
    private javax.swing.JRadioButton jCBResposta4;
    private javax.swing.JRadioButton jCBResposta5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPAlternativas;
    private javax.swing.JPanel jPPerguntas_cadastro;
    private javax.swing.JTextField jTAlterna1;
    private javax.swing.JTextField jTAlterna2;
    private javax.swing.JTextField jTAlterna3;
    private javax.swing.JTextField jTAlterna4;
    private javax.swing.JTextField jTAlterna5;
    private javax.swing.JTextField jTNumeroPerg;
    private javax.swing.JTextField jTPergunta;
    // End of variables declaration//GEN-END:variables
}
