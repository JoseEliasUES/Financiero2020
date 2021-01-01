/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Josue
 */
public class DetalleCompra {
    private Date fecha;
    private double precioCompra;
    private int cantidad;
    private int idProd;
    private int idProv;
    private int idCompra;
    private double total;

    public DetalleCompra(double precioCompra, int cantidad, int idProd, int idCompra) {
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.idProd = idProd;
        this.idCompra = idCompra;
    }

    public DetalleCompra(Date fecha, double precioCompra, int cantidad, int idProd, int idProv, int idCompra, double total) {
        this.fecha = fecha;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.idProd = idProd;
        this.idProv = idProv;
        this.idCompra = idCompra;
        this.total = total;
    }

    public DetalleCompra() {
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }
    
    
}
