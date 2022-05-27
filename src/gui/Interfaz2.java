package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import analizador.lexico.Lexico2;
import analizador.sintactico.AnalizadorPNR;

public class Interfaz2 extends JFrame {

    static int estadoTabla;

    public Interfaz2() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    AnalizadorPNR analizar = new AnalizadorPNR();
    File file;
    String[] columnasToken = {"Pila", "Entrada", "Salida"};
    static String[] columnasTAS = {" "};
    public DefaultTableModel modeloToken = new DefaultTableModel(
            this.columnasToken, 0) {
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    public DefaultTableModel modeloTAS = new DefaultTableModel(columnasTAS, 0) {
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    private JButton btnAnalizar;
    private JButton btnArchivo;
    private JButton btnTxtCodigoSalida;
    private JFileChooser jFileChooser;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTable jTable1;
    private JTable jTable2;
    private JTextPane tplEntrada;
    private JTextPane tplEntrada1;
    private JTextPane tplEntrada2;

    private void initComponents() {
        this.jFileChooser = new JFileChooser();
        this.jPanel1 = new JPanel();
        this.btnArchivo = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.tplEntrada = new JTextPane();
        this.jLabel1 = new JLabel();
        this.btnAnalizar = new JButton();
        this.jLabel4 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel3 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.tplEntrada1 = new JTextPane();
        this.btnTxtCodigoSalida = new JButton();
        this.jPanel4 = new JPanel();
        this.jLabel5 = new JLabel();
        this.jScrollPane4 = new JScrollPane();
        this.jTable2 = new JTable();
        this.jPanel5 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jScrollPane5 = new JScrollPane();
        this.tplEntrada2 = new JTextPane();

        setDefaultCloseOperation(3);

        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());

        this.btnArchivo.setText("Archivo");
        this.btnArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Interfaz2.this.btnArchivoActionPerformed(evt);
            }
        });
        this.tplEntrada.setEditable(false);
        this.jScrollPane1.setViewportView(this.tplEntrada);

        this.jLabel1.setFont(new Font("Tahoma", 1, 12));
        this.jLabel1.setText("Entrada de Archivo");

        this.btnAnalizar.setText("Analizar");
        this.btnAnalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Interfaz2.this.btnAnalizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel1Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                jPanel1Layout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                this.jScrollPane1,
                                                                -1, 212, 32767)
                                                        .addGroup(
                                                                jPanel1Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                this.jLabel1)
                                                                        .addGap(0,
                                                                                0,
                                                                                32767))
                                                        .addGroup(
                                                                jPanel1Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                this.btnArchivo)
                                                                        .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                -1,
                                                                                32767)
                                                                        .addComponent(
                                                                                this.btnAnalizar)))
                                        .addContainerGap()));

        jPanel1Layout
                .setVerticalGroup(jPanel1Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                jPanel1Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jLabel1)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                jPanel1Layout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                this.btnArchivo)
                                                        .addComponent(
                                                                this.btnAnalizar))
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.jScrollPane1)
                                        .addContainerGap()));

        this.jLabel4.setFont(new Font("Tahoma", 1, 12));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("ANALIZADOR SINTACTICO");
        this.jLabel4.setToolTipText("");

        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());

        this.jLabel2.setFont(new Font("Tahoma", 1, 12));
        this.jLabel2.setText("Tabla de Analisis Sintactico");

        this.jTable1.setModel(this.modeloTAS);
        this.jScrollPane2.setViewportView(this.jTable1);

        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout
                .setHorizontalGroup(jPanel2Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel2Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                jPanel2Layout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                this.jScrollPane2,
                                                                -1, 1096, 32767)
                                                        .addGroup(
                                                                jPanel2Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                this.jLabel2)
                                                                        .addGap(0,
                                                                                0,
                                                                                32767)))
                                        .addContainerGap()));

        jPanel2Layout
                .setVerticalGroup(jPanel2Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel2Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jLabel2)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.jScrollPane2, -1,
                                                197, 32767).addContainerGap()));

        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());

        this.jLabel3.setFont(new Font("Tahoma", 1, 12));
        this.jLabel3.setText("Codigo de Salida");

        this.tplEntrada1.setEditable(false);
        this.jScrollPane3.setViewportView(this.tplEntrada1);

        this.btnTxtCodigoSalida.setText("Txt Codigo Salida");
        this.btnTxtCodigoSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Interfaz2.this.btnTxtCodigoSalidaActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout
                .setHorizontalGroup(jPanel3Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel3Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                jPanel3Layout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                this.jScrollPane3)
                                                        .addGroup(
                                                                jPanel3Layout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                jPanel3Layout
                                                                                        .createParallelGroup(
                                                                                                GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                this.btnTxtCodigoSalida)
                                                                                        .addComponent(
                                                                                                this.jLabel3))
                                                                        .addGap(0,
                                                                                117,
                                                                                32767)))
                                        .addContainerGap()));

        jPanel3Layout
                .setVerticalGroup(jPanel3Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                jPanel3Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jLabel3)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.btnTxtCodigoSalida)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.jScrollPane3, -1,
                                                272, 32767).addContainerGap()));

        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());

        this.jLabel5.setFont(new Font("Tahoma", 1, 12));
        this.jLabel5.setText("Tabla de Movimientos Realizados");

        this.jTable2.setModel(this.modeloToken);
        this.jScrollPane4.setViewportView(this.jTable2);

        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout
                .setHorizontalGroup(jPanel4Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel4Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                jPanel4Layout
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                jPanel4Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                this.jLabel5)
                                                                        .addGap(0,
                                                                                0,
                                                                                32767))
                                                        .addComponent(
                                                                this.jScrollPane4,
                                                                -2, 0, 32767))
                                        .addContainerGap()));

        jPanel4Layout
                .setVerticalGroup(jPanel4Layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                jPanel4Layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(this.jLabel5)
                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.jScrollPane4, -1,
                                                301, 32767).addContainerGap()));

        this.jPanel5.setBorder(BorderFactory.createEtchedBorder());

        this.jLabel6.setFont(new Font("Tahoma", 1, 12));
        this.jLabel6.setText("Codigo de Entrada Analizador Sint.");

        this.tplEntrada2.setEditable(false);
        this.jScrollPane5.setViewportView(this.tplEntrada2);

        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(
                        jPanel5Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        jPanel5Layout
                                                .createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                .addComponent(this.jScrollPane5, -2,
                                                        208, -2)
                                                .addComponent(this.jLabel6))
                                .addContainerGap(-1, 32767)));

        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(
                        GroupLayout.Alignment.TRAILING,
                        jPanel5Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addComponent(this.jLabel6)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.jScrollPane5)
                                .addContainerGap()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING)
                                                .addComponent(this.jPanel2, -1,
                                                        -1, 32767)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        this.jPanel1,
                                                                        -2, -1,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        this.jPanel5,
                                                                        -2, -1,
                                                                        -2)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        this.jPanel4,
                                                                        -1, -1,
                                                                        32767)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        this.jPanel3,
                                                                        -2, -1,
                                                                        -2)))
                                .addContainerGap())
                .addComponent(this.jLabel4, -1, -1, 32767));

        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(this.jLabel4, -2, 15, -2)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.jPanel2, -2, -1, -2)
                                .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING,
                                                false)
                                                .addComponent(this.jPanel3, -1,
                                                        -1, 32767)
                                                .addComponent(this.jPanel4, -1,
                                                        -1, 32767)
                                                .addComponent(this.jPanel1, -1,
                                                        -1, 32767)
                                                .addComponent(this.jPanel5, -1,
                                                        -1, 32767))
                                .addGap(0, 0, 32767)));

        pack();
    }

    private void btnArchivoActionPerformed(ActionEvent evt) {
        this.analizar.cargarTabla();
        if (estadoTabla != 1) {
            cargarTablaTAS();
            estadoTabla = 1;
            File doc = new File("Codigo.txt");

            doc.delete();
        }
        AnalizadorPNR.movimientos.clear();
        this.tplEntrada1.setText("");
        while (this.modeloToken.getRowCount() > 0) {
            this.modeloToken.removeRow(0);
        }
        int returnVal = this.jFileChooser.showOpenDialog(this);
        if (returnVal == 0) {
            this.file = this.jFileChooser.getSelectedFile();
            try {
                this.tplEntrada.read(
                        new FileReader(this.file.getAbsolutePath()), null);
            } catch (IOException ex) {
                System.out.println("problem accessing file"
                        + this.file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void btnAnalizarActionPerformed(ActionEvent evt) {
        new Lexico2(this.file.getAbsolutePath());

        File file2 = new File("CodigoLexico.txt");
        try {
            this.tplEntrada2.read(new FileReader("CodigoLexico.txt"), null);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz2.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(
                    file2.getAbsolutePath()));
            try {
                String bufferIn;
                while ((bufferIn = in.readLine()) != null) {
                    int i = 0;
                    String cad = bufferIn.trim();
                    this.analizar.analizar(cad);
                }
                cargarTablaMov();

                this.tplEntrada1.read(new FileReader("Codigo.txt"), null);
            } catch (IOException localIOException1) {
            }
        } catch (FileNotFoundException localFileNotFoundException) {
        }
    }

    private void btnTxtCodigoSalidaActionPerformed(ActionEvent evt) {
        System.out.println(this.jTable2.getSelectedRow());
        Process p;
        try {
            p = Runtime.getRuntime().exec(
                    "C:/Windows/System32/notepad Codigo.txt");
        } catch (IOException localException) {
        }
    }

    public void cargarTablaMov() throws IOException {
        for (int i = 0; i < AnalizadorPNR.movimientos.size(); i++) {
            ArrayList datos = new ArrayList();
            datos = (ArrayList) AnalizadorPNR.movimientos.get(i);

            this.modeloToken.insertRow(this.modeloToken.getRowCount(),
                    new Object[]{datos.get(0), datos.get(1), datos.get(2)});
        }
        File archivo = new File("Codigo.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                archivo))) {
            for (int i = 0; i < AnalizadorPNR.movimientos.size(); i++) {
                ArrayList datos = new ArrayList();
                datos = (ArrayList) AnalizadorPNR.movimientos.get(i);
                if (datos.size() > 3) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                    bufferedWriter.write(datos.get(0).toString());
                    bufferedWriter.newLine();
                    bufferedWriter.write(datos.get(3).toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(datos.get(2).toString());
                bufferedWriter.newLine();
            }
        }
    }

    public void cargarTablaTAS() {
        for (int i = 1; i < AnalizadorPNR.getTas()[0].length; i++) {
            this.modeloTAS.addColumn(AnalizadorPNR.getTas()[0][i]);
        }
        for (int i = 1; i < AnalizadorPNR.getTas().length; i++) {
            Object[] newRow = new Object[AnalizadorPNR.getTas()[0].length];
            newRow[0] = AnalizadorPNR.getTas()[i][0];
            for (int j = 1; j < AnalizadorPNR.getTas()[0].length; j++) {
                newRow[j] = AnalizadorPNR.getTas()[i][j];
            }
            this.modeloTAS.insertRow(this.modeloTAS.getRowCount(), newRow);
        }
    }

    public String[] splitString(String linea) {
        StringTokenizer lex = new StringTokenizer(linea);

        String[] texto = new String[lex.countTokens()];
        for (int i = 0; i < texto.length; i++) {
            texto[i] = lex.nextToken();
        }
        return texto;
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Interfaz2.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Interfaz2.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Interfaz2.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Interfaz2.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz2().setVisible(true);
            }
        });
    }
}
