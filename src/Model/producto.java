/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * La clase `producto` representa un producto en el sistema.
 * 
 * @author mmarc
 */
public class producto {

    String Nomenclatura;
    Float precio;
    int cantidad;
    int idTipo;
    int idModelo;
    int idTalla;

    /**
     * Obtiene la nomenclatura del producto.
     *
     * @return La nomenclatura del producto.
     */
    public String getNomenclatura() {
        return Nomenclatura;
    }

    /**
     * Establece la nomenclatura del producto.
     *
     * @param Nomenclatura La nomenclatura del producto.
     */
    public void setNomenclatura(String Nomenclatura) {
        this.Nomenclatura = Nomenclatura;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El precio del producto.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad del producto.
     *
     * @return La cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     *
     * @param cantidad La cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ID del tipo del producto.
     *
     * @return El ID del tipo del producto.
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * Establece el ID del tipo del producto.
     *
     * @param idTipo El ID del tipo del producto.
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * Obtiene el ID del modelo del producto.
     *
     * @return El ID del modelo del producto.
     */
    public int getIdModelo() {
        return idModelo;
    }

    /**
     * Establece el ID del modelo del producto.
     *
     * @param idModelo El ID del modelo del producto.
     */
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * Obtiene el ID de la talla del producto.
     *
     * @return El ID de la talla del producto.
     */
    public int getIdTalla() {
        return idTalla;
    }

    /**
     * Establece el ID de la talla del producto.
     *
     * @param idTalla El ID de la talla del producto.
     */
    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    /**
     * Constructor de la clase producto.
     *
     * @param Nomenclatura La nomenclatura del producto.
     * @param idModelo El ID del modelo del producto.
     * @param idTalla El ID de la talla del producto.
     * @param idTipo El ID del tipo del producto.
     * @param cantidad La cantidad del producto.
     * @param precio El precio del producto.
     */
    public producto(String Nomenclatura, int idModelo, int idTalla, int idTipo, int cantidad, Float precio) {
        this.Nomenclatura = Nomenclatura;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idTipo = idTipo;
        this.idModelo = idModelo;
        this.idTalla = idTalla;
    }

    /**
     * Devuelve una representación en cadena del objeto producto.
     *
     * @return Representación en cadena del objeto producto.
     */
    @Override
    public String toString() {
        return "producto{" + ", Nomenclatura=" + Nomenclatura + ", precio=" + precio + ", cantidad=" + cantidad + ", idTipo=" + idTipo + ", idModelo=" + idModelo + ", idTalla=" + idTalla + '}';
    }

}
