/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author gemelos
 */
public class Venta {
    private Producto producto;
    private Integer cantidad;
    private double cuota;
    private double subtotal;
    private Date fecha;
    private int cliente;
    private String factura;
    private int meses;
    public Venta(Date fecha, int cliente, String factura) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.factura = factura;
    }

    public Venta(Producto producto, Integer cantidad, double cuota, double subtotal, int meses) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cuota = cuota;
        this.subtotal = subtotal;
        this.meses = meses;
    }
    
    public Venta(Producto producto, Integer cantidad, double cuota, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cuota = cuota;
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
    
}
