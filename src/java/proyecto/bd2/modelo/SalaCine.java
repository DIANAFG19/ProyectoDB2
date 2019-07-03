/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

/**
 *
 * @author campitos
 */
public class SalaCine {
    private Integer id;
    private String pelicula;

    public SalaCine() {
    }

    public SalaCine(Integer id, String pelicula) {
        this.id = id;
        this.pelicula = pelicula;
    }

    public SalaCine(String pelicula) {
        this.pelicula = pelicula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
}
