/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Josue
 */
public class Abono {

    private int id_abono;
    private int id_detVenta;
    private Date fecha;
    private Time hora;
    private double abono;
    private double mora;
    private Date proxPago;
    private String descripcion;
    
    private String factura;
    private String cliente;
    private String dui;
    private double credInicial;
    private double saldoPendiente;
    private Date fechaCredito;
    private double cuota;
    private int idCliente;
    private String producto;
    public Abono(int id_detVenta, Date fecha, Time hora, double abono, double mora, Date proxPago, String descripcion) {
        this.id_detVenta = id_detVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.abono = abono;
        this.mora = mora;
        this.proxPago = proxPago;
        this.descripcion = descripcion;
    }

    public Abono(int id_detVenta, Date fecha, double abono, double mora, Date proxPago) {
        this.id_detVenta = id_detVenta;
        this.fecha = fecha;
        this.abono = abono;
        this.mora = mora;
        this.proxPago = proxPago;
    }

    public Abono(int id_detVenta, double abono, double mora, Date proxPago) {
        this.id_detVenta = id_detVenta;
        this.abono = abono;
        this.mora = mora;
        this.proxPago = proxPago;
    }

    public Abono() {

    }

    public int getId_abono() {
        return id_abono;
    }

    public void setId_abono(int id_abono) {
        this.id_abono = id_abono;
    }

    public int getId_detVenta() {
        return id_detVenta;
    }

    public void setId_detVenta(int id_detVenta) {
        this.id_detVenta = id_detVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public Date getProxPago() {
        return proxPago;
    }

    public void setProxPago(Date proxPago) {
        this.proxPago = proxPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getCredInicial() {
        return credInicial;
    }

    public void setCredInicial(double credInicial) {
        this.credInicial = credInicial;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public Date getFechaCredito() {
        return fechaCredito;
    }

    public void setFechaCredito(Date fechaCredito) {
        this.fechaCredito = fechaCredito;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

}
