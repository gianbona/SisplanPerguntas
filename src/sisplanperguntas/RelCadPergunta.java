/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisplanperguntas;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte
 */
public class RelCadPergunta extends javax.swing.JFrame {

    /**
     * Creates new form RelCadPergunta
     */
    public RelCadPergunta() {
        initComponents();
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration()); 

         Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 

          int width = d.width-(in.left + in.top); 
          int height = d.height-(in.top + in.bottom); 
          setSize(width,height); 
          setLocation(in.left,in.top);
          
          
          
          
    }
    String alternativa1;
    String alternativa2;
    String alternativa3;
    String alternativa4;
    String alternativa5;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consulta = new javax.swing.JButton();
        fecha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsultaPerguntas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consulta.setText("Consultar");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        fecha.setText("Fechar");
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        jTConsultaPerguntas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Pergunta", "Nivel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTConsultaPerguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConsultaPerguntasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsultaPerguntas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Clicar com o botão Direito do Mouse para ver as Alternativas Cadastradas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                        .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(consulta, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_fechaActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        Connection connection = null;
        Statement statement = null;
        int linha = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Perguntas.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CADPERGUNTAS;");

           //Zera limpa a tabela grid
            DefaultTableModel mode = (DefaultTableModel) jTConsultaPerguntas.getModel();
            mode.setRowCount(0);
            
            while (resultSet.next()) {
                int numero = resultSet.getInt("NUMERO");
                String pergunta = resultSet.getString("PERGUNTA");
                String nivel = resultSet.getString("NIVEL");
                
                //Lista os clientes na tabela (Grid)
                DefaultTableModel model = (DefaultTableModel) jTConsultaPerguntas.getModel();
                model.addRow(new Object[]{numero, pergunta, nivel});
                
                linha++;
                
            }
            resultSet.close();
            statement.close();            
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + "erro na consulta de perguntas tela RelCadPergunta botão consultar " + e.getMessage());
            System.exit(0);
        }
    }//GEN-LAST:event_consultaActionPerformed

    private void jTConsultaPerguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultaPerguntasMouseClicked
        int linhaSelecionada =  jTConsultaPerguntas.getSelectedRow();
        int codpergunta      =  (int) jTConsultaPerguntas.getValueAt(linhaSelecionada, 0);
        
        Connection connection = null;
        Statement statement = null;
        int linha = 0;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Perguntas.db");
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CADPERGUNTAS WHERE NUMERO = '"+ codpergunta +"'");

           
            
            while (resultSet.next()) {
                String alter1 = resultSet.getString("ALTERNATIVA1");
                String alter2 = resultSet.getString("ALTERNATIVA2");
                String alter3 = resultSet.getString("ALTERNATIVA3");
                String alter4 = resultSet.getString("ALTERNATIVA4");
                String alter5 = resultSet.getString("ALTERNATIVA5");
                
                alternativa1 = alter1;
                alternativa2 = alter2;
                alternativa3 = alter3;
                alternativa4 = alter4;
                alternativa5 = alter5;
                
            }
            resultSet.close();
            statement.close();            
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + "erro na consulta de perguntas tela RelCadPergunta botão consultar " + e.getMessage());
            System.exit(0);
              }
                //Verificando se o botão direito do mouse foi clicado
                if ((evt.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                    JPopupMenu menu = new JPopupMenu();
                    add(menu);
                    JMenuItem item = new JMenuItem("Ver Alternativas");
                    menu.add(item);
                    menu.show(menu, evt.getX(), evt.getY());
                    
                    RelAlternativas alternativas = new RelAlternativas();
                    alternativas.setVisible(true);
                    alternativas.recebe(alternativa1,alternativa2,alternativa3,alternativa4,alternativa5);
                    alternativas.setLocationRelativeTo(this);
                }
         
          
    }//GEN-LAST:event_jTConsultaPerguntasMouseClicked

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
            java.util.logging.Logger.getLogger(RelCadPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelCadPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelCadPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelCadPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelCadPergunta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consulta;
    private javax.swing.JButton fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTConsultaPerguntas;
    // End of variables declaration//GEN-END:variables
}
