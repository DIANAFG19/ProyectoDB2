/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

/**
 *
 * @author YOO
 */
public class Cliente {
    private Integer numero;
    private Integer numeroAlmacen;
    private String nombre;
    
    public Integer getNumero() {
        return numero;
    }

    public Cliente(Integer numero, Integer numeroAlmacen, String nombre) {
        this.numero = numero;
        this.numeroAlmacen = numeroAlmacen;
        this.nombre = nombre;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumeroAlmacen() {
        return numeroAlmacen;
    }

    public void setNumeroAlmacen(Integer numeroAlmacen) {
        this.numeroAlmacen = numeroAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
}
