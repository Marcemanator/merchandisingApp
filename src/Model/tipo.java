/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * La clase `tipo` representa un tipo en el sistema.
 * 
 * @author mmarc
 */
public class tipo {
   
    int idTipo;
    String tipo;

    /**
     * Constructor de la clase tipo.
     *
     * @param tipo El tipo a establecer.
     */
    public tipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo.
     *
     * @return El tipo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo.
     *
     * @param tipo El tipo a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en cadena del objeto tipo.
     *
     * @return Representación en cadena del objeto tipo.
     */
    @Override
    public String toString() {
        return "tipo{" + "tipo=" + tipo + '}';
    }
    
    
}
