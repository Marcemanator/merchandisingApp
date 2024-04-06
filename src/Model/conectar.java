/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * La clase `conectar` proporciona métodos para conectarse a una base de datos MySQL,
 * realizar operaciones CRUD en una tabla de productos y realizar búsquedas de productos.
 * También incluye métodos para gestionar la conexión, cerrarla y realizar operaciones de auditoría.
 *
 * @author mmarc
 */
public class conectar {

    /**
     * Objeto de conexión a la base de datos.
     */
    public static Connection con;

    /**
     * Establece una conexión a la base de datos.
     *
     * @return La conexión establecida.
     */
    public static Connection conecta() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://qaiw565.marceweb.eu:3306/qaiw565?serverTimezone=UTC", "qaiw565", "Anabruc78");
            con.setAutoCommit(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se ha podido cargar el driver de la base de datos", ex);

        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se ha podido conectar a la base de datos", ex);

        }
        return con;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public static void cerrarConexion() {
        try {
            con.close();

        } catch (Exception e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se puede cerrar la conexión");

        }

    }

    /**
     * Verifica las credenciales de inicio de sesión de un usuario.
     *
     * @param user Nombre de usuario.
     * @param pass Contraseña del usuario.
     * @return `true` si las credenciales son válidas, `false` de lo contrario.
     */
    public static boolean loginUsuario(String user, String pass) {

        String SSQL = "SELECT Nombre,Pass FROM usuarios WHERE Nombre=? AND Pass=?";

        PreparedStatement pst;

        ResultSet rs;

        try {
            pst = con.prepareStatement(SSQL);

            pst.setString(1, user);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el usuario y/o contraseña" + e.getMessage());

        }
        return false;
    }

    /**
     * Recupera productos de la base de datos según una consulta SQL.
     *
     * @param consulta Consulta SQL para recuperar los productos.
     * @return Conjunto de resultados que contiene los productos.
     */
    public static ResultSet verProductos(String consulta) {

        Statement st;
        ResultSet datos = null;

        try {
            st = con.createStatement();
            datos = st.executeQuery(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No pueden recuperarse los productos");
        }
        return datos;

    }

    /**
     * Recupera productos de la base de datos según una consulta SQL.
     *
     * @param consulta Consulta SQL para recuperar los productos.
     * @return Conjunto de resultados que contiene los productos.
     */
    public static ResultSet verProductos2(String consulta) {

        Statement st;
        ResultSet datos2 = null;

        try {
            st = con.createStatement();
            datos2 = st.executeQuery(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No pueden recuperarse los productos");
        }
        return datos2;

    }

    /**
     * Reduce la cantidad de un producto en el stock.
     *
     * @param p Producto que se va a quitar del stock.
     */
    public static void quitarProducto(producto p) {

        String SSQL = "UPDATE productos SET cantidad = cantidad - 1 Where Nomenclatura= ?";

        try {
            PreparedStatement pst = con.prepareStatement(SSQL);

            pst.setString(1, p.getNomenclatura());
            pst.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo añadir el producto al Stock");

        }

    }

    /**
     * Actualiza la cantidad de un producto en el stock.
     *
     * @param p Producto que se va a actualizar en el stock.
     */
    public static void ActualizarProducto(producto p) {
        String SSQL = "UPDATE productos SET Cantidad = ? WHERE Nomenclatura = ?";
        String ASQL = "INSERT into auditor (UsuarioLogin,tabla,tipo_de_cambio,IdProducto) values(?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(SSQL);
            PreparedStatement past = con.prepareStatement(ASQL);
            pst.setInt(1, p.getCantidad());
            pst.setString(2, p.getNomenclatura());

            pst.execute();
            past.setString(1, usuarioActual.nombre);
            past.setString(2, "productos");
            past.setString(3, "UPDATE");
            past.setString(4, Nomenclatura.nomenclatura);
            past.execute();

            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException e) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo revertir los cambios", e);
            }
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo añadir el producto al Stock", ex);
        }
    }

    /**
     * Actualiza el usuario que realiza una acción en la auditoría.
     */
    public static void usuarioac() {

        String SSQL = "UPDATE auditor SET UsuarioLogin = ? WHERE id=(SELECT MAX(id) FROM auditor)";
        try {
            PreparedStatement pst = con.prepareStatement(SSQL);
            pst.setString(1, usuarioActual.nombre);
            pst.execute();
        } catch (SQLException e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo introducir el usuario");

        }
    }

    /**
     * Añade un nuevo producto al stock.
     *
     * @param p Producto que se va a añadir al stock.
     */
    public static void añadirProductoNuevo(producto p) {
        String SSQL = "Insert into productos(Nomenclatura, Cantidad, Precio,idTipo,idTalla,idModelo) values(?,?,?,?,?,?)";
        String ASQL = "INSERT into auditor (UsuarioLogin,tabla,tipo_de_cambio,IdProducto) values(?,?,?,?)";

        boolean Registrado;
        try {
            PreparedStatement pstp = con.prepareStatement(SSQL);
            PreparedStatement past = con.prepareStatement(ASQL);

            pstp.setString(1, p.getNomenclatura());
            pstp.setFloat(2, p.getPrecio());
            pstp.setInt(3, p.getCantidad());
            pstp.setInt(4, p.getIdTipo());
            pstp.setInt(5, p.getIdTalla());
            pstp.setInt(6, p.getIdModelo());
            pstp.execute();
            past.setString(1, usuarioActual.nombre);
            past.setString(2, "productos");
            past.setString(3, "INSERT");
            past.setString(4, Nomenclatura.nomenclatura);
            past.execute();

            con.commit();

            Registrado = true;
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException e) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo revertir los cambios", e);
            }
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Algo no va bien porque no se pudo crear el producto", ex);
            Registrado = false;
        }
    }

    /**
     * Actualiza el identificador del último cambio en la auditoría.
     */
   public static void identificadorControl() {
    String SSQL = "UPDATE auditor SET IdProducto = ? WHERE id = (SELECT max_id FROM (SELECT MAX(id) AS max_id FROM auditor) AS temp)";

    try {
        PreparedStatement pst = con.prepareStatement(SSQL);
        pst.setString(1, Nomenclatura.nomenclatura);
        pst.execute();
    } catch (SQLException e) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "no se ha podido insertar el identificador en el control", e);
    }
}

    /**
     * Elimina un producto del stock.
     *
     * @param p Producto que se va a eliminar del stock.
     */
    public static void borrar(producto p) {
        String SSQL = "DELETE FROM productos Where Nomenclatura=?";
        String ASQL = "INSERT into auditor (UsuarioLogin,tabla,tipo_de_cambio,IdProducto) values(?,?,?,?)";
        boolean registrado;
        try {
            PreparedStatement pst = con.prepareStatement(SSQL);
            PreparedStatement past = con.prepareStatement(ASQL);
            pst.setString(1, p.getNomenclatura());
            pst.executeUpdate();
            past.setString(1, usuarioActual.nombre);
            past.setString(2, "productos");
            past.setString(3, "DELETE");
            past.setString(4, Nomenclatura.nomenclatura);
            past.executeUpdate();

            con.commit();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No se pudo revertir los cambios", ex);
            }
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "Algo no va bien", e);
            registrado = false;
        }
    }

    /**
     * Realiza una búsqueda de productos en la base de datos según un término de búsqueda.
     *
     * @param searchTerm Término de búsqueda.
     * @return Conjunto de resultados que contiene los productos encontrados.
     */
    public static ResultSet Busqueda(String searchTerm) {
        ResultSet rs = null;

        String ssql = "SELECT productos.Nomenclatura, tipo.Tipo, modelo.Modelo, talla.Talla, productos.Precio, productos.Cantidad "
                + "FROM productos "
                + "JOIN tipo ON tipo.idTipo = productos.idTipo "
                + "JOIN modelo ON modelo.Modelo = productos.idModelo "
                + "JOIN talla ON talla.idTalla = productos.idTalla "
                + "WHERE productos.Nomenclatura LIKE ? "
                + "OR tipo.Tipo LIKE ? "
                + "OR modelo.Modelo LIKE ? "
                + "OR talla.Talla LIKE ?";

        try (PreparedStatement pst = con.prepareStatement(ssql)) {
            pst.setString(1, "%" + searchTerm + "%");
            pst.setString(2, "%" + searchTerm + "%");
            pst.setString(3, "%" + searchTerm + "%");
            pst.setString(4, "%" + searchTerm + "%");
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, "No pueden recuperarse los productos");
        }

        return rs;
    }

    String[][] mDatos;
    String[] Titulos = {"Identificador", "Tipo", "Modelo", "Talla", "Precio", "Cantidad"};

    /**
     * Recupera datos de productos de la base de datos y los muestra en una tabla.
     */
    public static void tablaDatos() {

        DefaultTableModel dft = new DefaultTableModel();
        TableRowSorter<TableModel> trs;
        ResultSet rs;

        int contador = 0;
        try {
            Statement stmn_con = con.createStatement();
            ResultSet rs_con = stmn_con.executeQuery("SELECT COUNT(*) FROM productos");
            if (rs_con.next()) {

            }
            Statement stmt = con.createStatement();

            rs = stmt.executeQuery("Select productos.Nomenclatura,tipo.Tipo,modelo.Modelo,talla.Talla,"
                    + "productos.Precio,productos.Cantidad from productos join tipo join modelo join talla on tipo.idTipo=productos.idTipo "
                    + "and modelo.Modelo=productos.idModelo and talla.idTalla=productos.idTalla order by productos.Nomenclatura ");
            int cont = 0;

            while (rs.next()) {

            }
        } catch (SQLException e) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, e);

        }

    }

}
