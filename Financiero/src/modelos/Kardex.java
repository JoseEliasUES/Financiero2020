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
public class Kardex {

    private Date fecha;
    private String detalle;
    private int cantidadC;
    private double precioUC;
    private double totalC;
    private int cantidadV;
    private double precioUV;
    private double totalV;
    private int cantidadE;
    private double precioUE;
    private double totalE;

    public Kardex() {

    }

    public Kardex(Date fecha, String detalle, int cantidadC, double precioUC, double totalC, int cantidadV, double precioUV, double totalV, int cantidadE, double precioUE, double totalE) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.cantidadC = cantidadC;
        this.precioUC = precioUC;
        this.totalC = totalC;
        this.cantidadV = cantidadV;
        this.precioUV = precioUV;
        this.totalV = totalV;
        this.cantidadE = cantidadE;
        this.precioUE = precioUE;
        this.totalE = totalE;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidadC() {
        return cantidadC;
    }

    public void setCantidadC(int cantidadC) {
        this.cantidadC = cantidadC;
    }

    public double getPrecioUC() {
        return precioUC;
    }

    public void setPrecioUC(double precioUC) {
        this.precioUC = precioUC;
    }

    public double getTotalC() {
        return totalC;
    }

    public void setTotalC(double totalC) {
        this.totalC = totalC;
    }

    public int getCantidadV() {
        return cantidadV;
    }

    public void setCantidadV(int cantidadV) {
        this.cantidadV = cantidadV;
    }

    public double getPrecioUV() {
        return precioUV;
    }

    public void setPrecioUV(double precioUV) {
        this.precioUV = precioUV;
    }

    public double getTotalV() {
        return totalV;
    }

    public void setTotalV(double totalV) {
        this.totalV = totalV;
    }

    public int getCantidadE() {
        return cantidadE;
    }

    public void setCantidadE(int cantidadE) {
        this.cantidadE = cantidadE;
    }

    public double getPrecioUE() {
        return precioUE;
    }

    public void setPrecioUE(double precioUE) {
        this.precioUE = precioUE;
    }

    public double getTotalE() {
        return totalE;
    }

    public void setTotalE(double totalE) {
        this.totalE = totalE;
    }
}
