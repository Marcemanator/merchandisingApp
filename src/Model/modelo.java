/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * La clase `modelo` representa un modelo de producto.
 * 
 * @author mmarc
 */
public class modelo {

    int idModelo;
    String modelo;

    /**
     * Constructor de la clase modelo.
     *
     * @param modelo Nombre del modelo.
     */
    public modelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el nombre del modelo.
     *
     * @return Nombre del modelo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el nombre del modelo.
     *
     * @param modelo Nombre del modelo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve una representación en cadena del objeto modelo.
     *
     * @return Representación en cadena del objeto modelo.
     */
    @Override
    public String toString() {
        return "modelo{" + "modelo=" + modelo + '}';
    }

}
