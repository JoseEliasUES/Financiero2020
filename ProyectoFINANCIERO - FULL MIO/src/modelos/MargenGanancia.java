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
public class MargenGanancia {
    private Date fecha;
    private double porcentaje;
   private Categoria categoria;
   private int categoria2;

    public MargenGanancia() {
    }

    public MargenGanancia(Date fecha, double porcentaje, Categoria categoria) {
        this.fecha = fecha;
        this.porcentaje = porcentaje;
        this.categoria = categoria;
    }

    public MargenGanancia(Date fecha, double porcentaje, int categoria2) {
        this.fecha = fecha;
        this.porcentaje = porcentaje;
        this.categoria2 = categoria2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(int categoria2) {
        this.categoria2 = categoria2;
    }
}
