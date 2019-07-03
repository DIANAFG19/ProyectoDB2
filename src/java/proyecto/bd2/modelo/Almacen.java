/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

/**
 *
 * @author T-
 */
public class Almacen {
    
    private Integer numeroAlmacen;
    private String ubicacionAlmacen;

    public Almacen(Integer numeroAlmacen, String ubicacionAlmacen) {
        this.numeroAlmacen = numeroAlmacen;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }

    public Almacen() {
    }

    /**
     * @return the numeroAlmacen
     */
    public Integer getNumeroAlmacen() {
        return numeroAlmacen;
    }

    /**
     * @return the ubicacionAlmacen
     */
    public String getUbicacionAlmacen() {
        return ubicacionAlmacen;
    }

    /**
     * @param numeroAlmacen the numeroAlmacen to set
     */
    public void setNumeroAlmacen(Integer numeroAlmacen) {
        this.numeroAlmacen = numeroAlmacen;
    }

    /**
     * @param ubicacionAlmacen the ubicacionAlmacen to set
     */
    public void setUbicacionAlmacen(String ubicacionAlmacen) {
        this.ubicacionAlmacen = ubicacionAlmacen;
    }
    
    
}
