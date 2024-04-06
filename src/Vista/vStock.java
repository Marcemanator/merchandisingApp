/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Model.Nomenclatura;
import Model.conectar;
import static Model.conectar.verProductos;
import Model.mail;
import Model.producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * La clase `StockManager` proporciona métodos para gestionar el stock de productos, incluyendo la visualización,
 * actualización, eliminación y exportación de datos, así como el envío de correos electrónicos con información relevante.
 * 
 * Esta clase depende de la clase `conectar` para realizar operaciones en la base de datos y de la clase `mail` para
 * enviar correos electrónicos.
 * 
 * @author mmarc
 */

public class vStock extends javax.swing.JDialog {

    DefaultTableModel dft = new DefaultTableModel();
    TableRowSorter<TableModel> trs;
    ResultSet rs;
    String[][] mDatos;
    String[] Titulos = {"Identificador", "Tipo", "Modelo", "Talla", "Precio", "Cantidad"};

    /**
     * Creates new form vStock
     * @param parent
     * @param modal
     */
    public vStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tableModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        añadirProductosBt = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btRefrescar = new javax.swing.JButton();
        btBajar = new javax.swing.JButton();
        btSubir = new javax.swing.JButton();
        actualizarCantStock1 = new javax.swing.JButton();
        textBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaContenidos = new javax.swing.JTable();
        textMail = new javax.swing.JTextField();
        btEnvio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        añadirProductosBt.setBackground(new java.awt.Color(102, 102, 255));
        añadirProductosBt.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        añadirProductosBt.setForeground(new java.awt.Color(255, 255, 255));
        añadirProductosBt.setText("Añadir  Productos");
        añadirProductosBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirProductosBtActionPerformed(evt);
            }
        });

        btBorrar.setBackground(new java.awt.Color(102, 102, 255));
        btBorrar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btBorrar.setText("Borrar fila stock");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        btRefrescar.setBackground(new java.awt.Color(102, 102, 255));
        btRefrescar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btRefrescar.setText("Refrescar");
        btRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefrescarActionPerformed(evt);
            }
        });

        btBajar.setBackground(new java.awt.Color(102, 102, 255));
        btBajar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btBajar.setForeground(new java.awt.Color(255, 255, 255));
        btBajar.setText("v");
        btBajar.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btBajar.setMaximumSize(new java.awt.Dimension(27, 27));
        btBajar.setMinimumSize(new java.awt.Dimension(27, 27));
        btBajar.setPreferredSize(new java.awt.Dimension(27, 27));
        btBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBajarActionPerformed(evt);
            }
        });

        btSubir.setBackground(new java.awt.Color(102, 102, 255));
        btSubir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSubir.setForeground(new java.awt.Color(255, 255, 255));
        btSubir.setText("^");
        btSubir.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btSubir.setMaximumSize(new java.awt.Dimension(27, 27));
        btSubir.setMinimumSize(new java.awt.Dimension(27, 27));
        btSubir.setPreferredSize(new java.awt.Dimension(27, 27));
        btSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubirActionPerformed(evt);
            }
        });

        actualizarCantStock1.setBackground(new java.awt.Color(102, 102, 255));
        actualizarCantStock1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        actualizarCantStock1.setForeground(new java.awt.Color(255, 255, 255));
        actualizarCantStock1.setText("Actualizar Cantidad Stock");
        actualizarCantStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarCantStock1ActionPerformed(evt);
            }
        });

        textBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscaKeyTyped(evt);
            }
        });

        jLabel1.setText("Busqueda por tipo :");

        tablaContenidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tablaContenidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificador", "Tipo", "Modelo", "Talla", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaContenidos);

        btEnvio.setBackground(new java.awt.Color(102, 102, 255));
        btEnvio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEnvio.setForeground(new java.awt.Color(255, 255, 255));
        btEnvio.setText("Enviar");
        btEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnvioActionPerformed(evt);
            }
        });

        jLabel2.setText("Escribe tu mail aqui y te enviaremos una ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel3.setText("copia de lo que hay en pantalla.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEnvio)))
                .addGap(93, 93, 93))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 28, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(añadirProductosBt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(actualizarCantStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(340, 340, 340)
                            .addComponent(btSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(340, 340, 340)
                            .addComponent(btBajar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 29, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnvio))
                .addGap(54, 54, 54))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 354, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(añadirProductosBt)
                        .addComponent(actualizarCantStock1)
                        .addComponent(btSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btRefrescar)
                        .addComponent(btBorrar)
                        .addComponent(btBajar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirProductosBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirProductosBtActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        nuevoProducto np = new nuevoProducto(frame, true);
        np.setVisible(true);

    }//GEN-LAST:event_añadirProductosBtActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
        Borrar();

    }//GEN-LAST:event_btBorrarActionPerformed

    private void btRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefrescarActionPerformed

        tableModel();

    }//GEN-LAST:event_btRefrescarActionPerformed

    private void btBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBajarActionPerformed
        // TODO add your handling code here:

        int indiceActual = tablaContenidos.getSelectedRow();
        if (indiceActual < tablaContenidos.getRowCount() - 1) {
            tablaContenidos.setRowSelectionInterval(indiceActual + 1, indiceActual + 1);

        }
    }//GEN-LAST:event_btBajarActionPerformed

    private void btSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubirActionPerformed
        // TODO add your handling code here:

        int indiceActual = tablaContenidos.getSelectedRow();
        if (indiceActual > 0) {
            tablaContenidos.setRowSelectionInterval(indiceActual - 1, indiceActual - 1);
        }

    }//GEN-LAST:event_btSubirActionPerformed

    private void actualizarCantStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarCantStock1ActionPerformed

        // TODO add your handling code here:
        actualizar();

    }//GEN-LAST:event_actualizarCantStock1ActionPerformed

    private void textBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscaKeyTyped
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_textBuscaKeyTyped

    private void btEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnvioActionPerformed
        // TODO add your handling code here:

        tableModel();
        tabla();
        mailing();

    }//GEN-LAST:event_btEnvioActionPerformed

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
            java.util.logging.Logger.getLogger(vStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vStock dialog = new vStock(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarCantStock1;
    private javax.swing.JButton añadirProductosBt;
    private javax.swing.JButton btBajar;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btEnvio;
    private javax.swing.JButton btRefrescar;
    private javax.swing.JButton btSubir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaContenidos;
    private javax.swing.JTextField textBusca;
    private javax.swing.JTextField textMail;
    // End of variables declaration//GEN-END:variables
    
    /** Variables de control de cantidad. */
    int Cantid;
    int Can;
    int Canti;

    /** Variables de identificación y manipulación de datos. */
    int Model;
    int columna;
    int id;
    String idMod;
    String nomenclatura;
    int idmodel;
    int idTalla;
    int idTipo;

    /** Variables de identificación y manipulación de productos. */
    int idModelo;
    String nom;
    int cantidad;
    Float precio;

    /** Arrays para almacenar datos de productos y títulos de columnas. */
    String[][] mDat;
    String[] Tit = {"Identificador", "Tipo", "Modelo", "Talla", "Precio", "Cantidad"};

    /** Variables para el envío de correos electrónicos. */
    String asunto = "Mail del stock de producto";
    String mensaje;
    String destinatario;
    String tipocambio;
    String tabla;

    /**
     * Recupera y muestra los productos disponibles en la tabla.
     * 
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public void Stock() throws SQLException {
        conectar.conecta();

        DefaultTableModel dft = new DefaultTableModel();
        ResultSet rs = conectar.verProductos("Select productos.Nomenclatura,tipo.Tipo,modelo.Modelo,talla.Talla,"
                + "productos.Precio,productos.Cantidad from productos join tipo join modelo join talla on tipo.idTipo=productos.idTipo "
                + "and modelo.Modelo=productos.idModelo and talla.idTalla=productos.idTalla order by productos.Nomenclatura ");
        dft.setColumnIdentifiers(new Object[]{"Identificador", "Tipo", "Modelo", "Talla", "Precio", "Cantidad"});
        try {
            while (rs.next()) {
                dft.addRow(new Object[]{rs.getString("productos.Nomenclatura"), rs.getString("tipo.Tipo"), rs.getString("modelo.Modelo"), rs.getString("talla.Talla"), rs.getFloat("productos.Precio"), rs.getInt("productos.Cantidad")});
            }
            tablaContenidos.setModel(dft);
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Algo no va bien", ex);

        }

        conectar.cerrarConexion();
    }

    /**
     * Construye un modelo de tabla con los datos de los productos.
     */
    public void tableModel() {
        conectar.conecta();
        DefaultTableModel dft = new DefaultTableModel();
        int contador = 0;
        try {
            ResultSet rs1 = conectar.verProductos("SELECT COUNT(*) FROM productos");
            if (rs1.next()) {
                contador = rs1.getInt(1);
            }
            ResultSet rs2 = conectar.verProductos("Select productos.Nomenclatura,tipo.Tipo,modelo.Modelo,talla.Talla,"
                    + "productos.Precio,productos.Cantidad from productos join tipo join modelo join talla on tipo.idTipo=productos.idTipo "
                    + "and modelo.Modelo=productos.idModelo and talla.idTalla=productos.idTalla order by productos.Nomenclatura ");
            int cont = 0;
            mDat = new String[contador][6];
            while (rs2.next()) {
                mDat[cont][0] = rs2.getString("productos.Nomenclatura");
                mDat[cont][1] = rs2.getString("tipo.Tipo");
                mDat[cont][2] = rs2.getString("modelo.Modelo");
                mDat[cont][3] = rs2.getString("talla.Talla");

                String precio = Float.toString(rs2.getFloat("productos.Precio"));
                mDat[cont][4] = precio;
                String contar = Integer.toString(rs2.getInt("productos.Cantidad"));
                mDat[cont][5] = contar;
                cont = cont + 1;
            }

            dft = new DefaultTableModel(mDat, Tit) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            tablaContenidos.setModel(dft);
            trs = new TableRowSorter<>(dft);
            tablaContenidos.setRowSorter(trs);
        } catch (SQLException e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Filtra los datos de la tabla según el texto especificado.
     */
    private void filtrar() {
        try {
            trs.setRowFilter(RowFilter.regexFilter(textBusca.getText()));
        } catch (Exception e) {
            // Captura y maneja cualquier excepción que pueda ocurrir al filtrar
        }
    }

    /**
     * Borra un producto de la tabla y de la base de datos.
     */
    public void Borrar() {
        int filaSeleccionada = tablaContenidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tablaContenidos.getModel();
            String nomenclatura = model.getValueAt(filaSeleccionada, 0).toString();
            Nomenclatura.nomenclatura = nomenclatura;

            producto p = new producto(nomenclatura, idModelo, idTalla, idTipo, cantidad, precio);
            p.setNomenclatura(nomenclatura);
            conectar.borrar(p);
          
            model.removeRow(filaSeleccionada);
        } else {
            // Mostrar un mensaje si no hay ninguna fila seleccionada
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada");
        }
    }

    /**
     * Identifica el producto seleccionado en la tabla.
     */
    public void identificador() {
        int filaSeleccionada = tablaContenidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tablaContenidos.getModel();
            Nomenclatura.nomenclatura = model.getValueAt(filaSeleccionada, 0).toString();
        }
    }

    /**
     * Actualiza la cantidad de un producto seleccionado en la tabla.
     */
    public void actualizar() {
        int filaSeleccionada = tablaContenidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tablaContenidos.getModel();
            nom = model.getValueAt(filaSeleccionada, 0).toString();
            Nomenclatura.nomenclatura = nom;

            String cantidad = model.getValueAt(filaSeleccionada, 5).toString();

            String Cnt = JOptionPane.showInputDialog(null, "Introduce un valor para cantidad");
            int Cantidade = Integer.parseInt(Cnt);

            producto pr = new producto(nom, idModelo, idTalla, idTipo, Canti, precio);
            pr.setCantidad(Cantidade);
            pr.setNomenclatura(nom);

            conectar.conecta();
            conectar.ActualizarProducto(pr);
            

            conectar.cerrarConexion();
        }
    }

    /**
     * Obtiene una lista de todos los productos almacenados en la base de datos.
     * 
     * @return Una lista de objetos `producto` que representan los productos almacenados en la base de datos.
     */
    public ArrayList<producto> obtenerProductos() {
        ArrayList<producto> productos = new ArrayList<>();
        ResultSet datos = verProductos("SELECT * FROM productos");

        try {
            while (datos.next()) {
                producto p = new producto(nom, idModelo, idTalla, idTipo, Canti, precio);

                p.setNomenclatura(datos.getString("Nomenclatura"));
                p.setIdModelo(datos.getInt("idModelo"));
                p.setIdTalla(datos.getInt("idTalla"));
                p.setIdTipo(datos.getInt("idTipo"));
                p.setCantidad(datos.getInt("Cantidad"));
                p.setPrecio(datos.getFloat("Precio"));
                productos.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No pueden recuperarse los productos");
        }

        return productos;
    }

    /**
     * Exporta los datos de la tabla de productos a un archivo CSV.
     */
    public void tabla() {
        // Paso 1: Escribe los datos de la tabla en un archivo
        try (FileWriter writer = new FileWriter("tablaStock.csv")) {
            for (int i = 0; i < tablaContenidos.getRowCount(); i++) {
                for (int j = 0; j < tablaContenidos.getColumnCount(); j++) {
                    writer.write(tablaContenidos.getValueAt(i, j).toString() + ",");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Envía un correo electrónico con los datos de la tabla de productos adjuntos.
     */
    public void mailing() {
        destinatario = textMail.getText();
        mensaje = "Esto que llega es la BBDD Merchanidisng";
        asunto = "Tabla de la BBDD";
        mail email = new mail(asunto, mensaje, destinatario, "tablaStock.csv");

        if (email.MailAdjunto()) {
            JOptionPane.showMessageDialog(this, "Mensaje enviado correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "No fué posible enviar el mensaje");
        }
        textMail.setText("");
        textMail.setEnabled(true);
    }
}