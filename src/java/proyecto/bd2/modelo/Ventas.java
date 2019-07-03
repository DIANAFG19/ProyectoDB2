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
public class Ventas {
    private Integer id;
    private Integer numeroCliente;
    private Integer numeroVendedor;
    private Float monto;

    public Ventas() {
    }

    public Ventas(Integer id, Integer numeroCliente, Integer numeroVendedor, Float monto) {
        this.id = id;
        this.numeroCliente = numeroCliente;
        this.numeroVendedor = numeroVendedor;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Integer getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(Integer numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
    
}
