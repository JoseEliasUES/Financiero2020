/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;


/**
 *
 * @author TonyFabian
 */
public class Activofijo {
    
    private int id_activof;
    private String  codigo;
    private String  descripcion;
    private MarcaV marca;
    private String  modelo;
    private String  serie;
    private Date fechaadq ;
    private double valor;
    private String tipo;

    public Activofijo(int id_activof, String codigo, String descripcion, MarcaV marca, String modelo, String serie, Date fechaadq, double valor, String tipo) {
        this.id_activof = id_activof;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.fechaadq = fechaadq;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Activofijo(String codigo, String descripcion, MarcaV marca, String modelo, String serie, Date fechaadq, double valor, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.fechaadq = fechaadq;
        this.valor = valor;
        this.tipo = tipo;
    }
   
    
    public Activofijo() {
    }

    public int getId_activof() {
        return id_activof;
    }

    public void setId_activof(int id_activof) {
        this.id_activof = id_activof;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MarcaV getMarca() {
        return marca;
    }

    public void setMarca(MarcaV marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getFechaadq() {
        return fechaadq;
    }

    public void setFechaadq(Date fechaadq) {
        this.fechaadq = fechaadq;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
