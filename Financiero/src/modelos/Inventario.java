/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;
import modelos.Categoria;
import proyectofinanciero.Marca;

/**
 *
 * @author gemelos
 */
public class Inventario {
    //Entradas
    private Double precioCompra;
    private int cantidadC;
    private Date fechaC;
    private String nombreC;
    private String modeloC;
    private MarcaV marcaC;
    private Categoria catC;
    private int Stock;
    //Salidas

    public Inventario() {
    }

    public Inventario(Double precioCompra, int cantidadC, Date fechaC, String nombreC, String modeloC, MarcaV marcaC, Categoria catC) {
        this.precioCompra = precioCompra;
        this.cantidadC = cantidadC;
        this.fechaC = fechaC;
        this.nombreC = nombreC;
        this.modeloC = modeloC;
        this.marcaC = marcaC;
        this.catC = catC;
    }

    public Categoria getCatC() {
        return catC;
    }

    public void setCatC(Categoria catC) {
        this.catC = catC;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidadC() {
        return cantidadC;
    }

    public void setCantidadC(int cantidadC) {
        this.cantidadC = cantidadC;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getModeloC() {
        return modeloC;
    }

    public void setModeloC(String modeloC) {
        this.modeloC = modeloC;
    }

    public MarcaV getMarcaC() {
        return marcaC;
    }

    public void setMarcaC(MarcaV marcaC) {
        this.marcaC = marcaC;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
}
