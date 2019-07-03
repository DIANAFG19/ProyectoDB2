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
public class Vendedor {
    private Integer numero;
    private String nombre;
    private String area;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Vendedor(int numero, String nombre, String area) {
        this.numero = numero;
        this.nombre = nombre;
        this.area = area;
    }

    public Vendedor() {
    }
}
