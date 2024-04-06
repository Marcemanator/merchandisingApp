/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * La clase `talla` representa una talla en el sistema.
 * 
 * @author mmarc
 */
public class talla {
   
   int idTalla;
   String talla;

    /**
     * Constructor de la clase talla.
     *
     * @param talla La talla a establecer.
     */
    public talla(String talla) {
        this.talla = talla;
    }

    /**
     * Obtiene la talla.
     *
     * @return La talla.
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Establece la talla.
     *
     * @param talla La talla a establecer.
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Devuelve una representación en cadena del objeto talla.
     *
     * @return Representación en cadena del objeto talla.
     */
    @Override
    public String toString() {
        return "talla{" + "talla=" + talla + '}';
    }
   
}
