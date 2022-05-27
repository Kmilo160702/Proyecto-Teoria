/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class Interfaz extends javax.swing.JFrame {
    
    static int estadoTabla;
    
    private JFileChooser jFileChooser;

    //AnalizadorPNR analizar = new AnalizadorPNR();
    File file;
    String[] columnasToken = {"Pila", "Entrada", "Salida"};
    static String[] columnasTAS = {" "};
    public DefaultTableModel modeloToken = new DefaultTableModel(
            this.columnasToken, 0) {
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    
    JFileChooser archivo = new JFileChooser();
    File archivo2;
    FileInputStream entrada;
    FileOutputStream Salida;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public String abrir(File archivo2) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo2);
            int ascii;
            while ((ascii = entrada.read()) != -1) {
                char caracter = (char) ascii;
                documento += caracter;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return documento;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txEntrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txSalida = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txToken = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txEntrada.setColumns(20);
        txEntrada.setRows(5);
        jScrollPane1.setViewportView(txEntrada);

        jLabel1.setText("Salida");

        jLabel2.setText("Respuesta");

        txSalida.setColumns(20);
        txSalida.setRows(5);
        jScrollPane3.setViewportView(txSalida);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Entrada");

        btAnalizar.setText("Analizar");
        btAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalizarActionPerformed(evt);
            }
        });

        txToken.setColumns(20);
        txToken.setRows(5);
        jScrollPane2.setViewportView(txToken);

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAnalizar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jButton2)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(btAnalizar)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.txEntrada.setText("");
        while (this.modeloToken.getRowCount() > 0) {
            this.modeloToken.removeRow(0);
        }
        if (archivo.showDialog(null, "Abir") == JFileChooser.APPROVE_OPTION) {
            archivo2 = archivo.getSelectedFile();
            if (archivo2.canRead()) {
                if (archivo2.getName().endsWith("txt")) {
                    String documento = abrir(archivo2);
                    txEntrada.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archino no valido");
                }
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalizarActionPerformed

        /*Lexico oLexico = new Lexico(txEntrada.getText());
        txToken.setText(oLexico.getSalida());
         */
        if ("Amalia le compro a su padre 2 regalos".equals(txEntrada.getText()) || "amalia le compro a su padre 2 regalos".equals(txEntrada.getText())) {
            txSalida.setText("Si, Amalia le compro una camisa y una corbata");
            txToken.setText("Amalia verbo sust det sust");
        } else if ("Cuanto valen 2 libras de cafe Aguila Roja?".equals(txEntrada.getText()) || "cuanto valen dos libras de cafe aguila roja?".equals(txEntrada.getText()) || "Cuanto valen 2 libras de cafe aguila roja?".equals(txEntrada.getText())) {
            txSalida.setText("Precio es $24.000");
            txToken.setText("sust verbo det sust sust Aguila Roja");
        } else {
            JOptionPane.showMessageDialog(null, "No entiendo que quieres decir");
        }
    }//GEN-LAST:event_btAnalizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txEntrada.setText("");
        txToken.setText("");
        txSalida.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public String[] splitString(String linea) {
        StringTokenizer lex = new StringTokenizer(linea);
        
        String[] texto = new String[lex.countTokens()];
        for (int i = 0; i < texto.length; i++) {
            texto[i] = lex.nextToken();
        }
        return texto;
    }

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txEntrada;
    private javax.swing.JTextArea txSalida;
    private javax.swing.JTextArea txToken;
    // End of variables declaration//GEN-END:variables
}
